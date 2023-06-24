

  //////////////////show list//////////////////////////////
  const pageLimit=10;
async function getProductsList(category_id, page) {
  try {
    var linkGetProducts = 'http://localhost:9999/orders';


    const response = await fetch(linkGetProducts);
    const products = await response.json();

    const ul = document.querySelector('#mt-admin-product-lists');
    ul.innerHTML = '';

    const totalProducts = products.length;
    const offset = (page - 1) * pageLimit;
    const start = offset + 1;
    var end = start + pageLimit - 1;
    if (end > products.length) {
      end = products.length;
    }
    renderPagination(category_id, totalProducts, page);
    const pOffset = document.getElementById('p-offset');
    pOffset.innerHTML = `Showing <strong><span id="span-start">${start}</span>–<span id="span-end">${end}</span></strong> of <strong>${totalProducts}</strong> results`;

    for (let i = offset; i < offset + pageLimit && i < products.length; i++) {
      const product = products[i];


        const html = `<div class="row border rowOne" id="rowOne${product.id}">
                        <a href="#">
                        <div class="col-xs-12 col-sm-1">
                          <strong class="product-name">${product.id}</strong>
                        </div>

                        <div class="col-xs-12 col-sm-4">
                          <strong class="product-name">${product.orderDate}</strong>
                        </div>
                        <div class="col-xs-12 col-sm-3">
                          <strong class="price">${formatCurrency(product.totalPrice)}</strong>
                        </div>
                       <div class="col-xs-12 col-sm-3">
                         <strong class="price">${product.khachHang?product.khachHang.hoten:''}</strong>
                       </div>
                       </a>

                  </div>`;
        ul.innerHTML += html;
      }

  } catch (error) {
    console.log(error);
  }
}
  loadListHtml(null,1)

  function loadListHtml(category_id,page){
      getProductsList(category_id,page);
  }


  function renderPagination(category_id, totalProducts, currentPage) {
    const nav = document.querySelector('.mt-pagination');
    nav.innerHTML = '';

    const totalPages = Math.ceil(totalProducts / pageLimit);

    const ul = document.createElement('ul');
    ul.classList.add('list-inline');

    for (let i = 1; i <= totalPages; i++) {
      const li = document.createElement('li');
      const link = document.createElement('a');
      if (i === currentPage) {
              link.classList.add('mt-pagination-active');
          }
      link.href = '#';
      link.innerText = i;
      link.addEventListener('click', e => {
          e.preventDefault();
          const page = parseInt(e.target.textContent);
          getProductsList(category_id,page);
        });

      li.appendChild(link);
      ul.appendChild(li);
    }

    nav.appendChild(ul);
  }
  getCategoriesList();

  function getCategoriesList(){
  fetch('http://localhost:9999/categories')
    .then(response => response.json())
    .then(categories => {
      categories.forEach(async category => {
        const response = await fetch(`http://localhost:9999/products/findByCategory/${category.id}`);
        const products = await response.json();
        const count = products.length;
        const html = `
          <li>
            <a href="#" onclick="loadListHtml(${category.id},1)">
              <span class="name">${category.name}</span>
              <span class="num">${count}</span>
            </a>
          </li>
        `;
        const ul = document.querySelector('.category-list');
        ul.innerHTML += html;
      });
    })
    .catch(error => {
      console.log(error);
    });
  }
function deleteProduct(event, product_id, link){
    event.preventDefault();
    fetch('http://localhost:9999/products/'+product_id, {
          method: "DELETE",
        })
          .then(response => {
            if (response.ok) {
              // Đăng ký thành công
              link.parentNode.parentNode.remove();
              return response.json();
            } else {
              // Xử lý khi đăng ký thất bại, ví dụ hiển thị thông báo lỗi
              throw new Error("DELETE failed");
            }
          })
          .then(data => {
            console.log(data);
          })
          .catch(error => {
            // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
            console.log(error);
          });
}