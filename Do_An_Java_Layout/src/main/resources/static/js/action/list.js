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
          <a href="#" onclick="choose_category(event,${category.id})">
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

getCategoriesList();
///////////////////////sort///////////////////////////
//0 : khong sort
//1 : Gia tang dan
//2: Gia giam dan
//3: Ten A-Z
//4: Ten Z-A
var SORT_OPTION=0;
function choose_sort(event, sort_option){
    event.preventDefault();
    if(SORT_OPTION!=sort_option){
        SORT_OPTION=sort_option;
        getProductsList(1);
    }
}
var CATEGORY_ID=0;
function choose_category(event, category_option){
    event.preventDefault();
    if(CATEGORY_ID!=category_option){
        CATEGORY_ID=category_option;
        getProductsList(1);
    }
}
var PAGE_LIMIT=9;

function sortNameAZ(a, b) {

  if(a.name==null){return -1;}
  if(b.name==null){return 1;}
  var nameA = a.name.toUpperCase(); // Chuyển tên thành chữ hoa để so sánh
  var nameB = b.name.toUpperCase();


  if (nameA < nameB) {
    return -1;
  }
  if (nameA > nameB) {
    return 1;
  }
  return 0;
}
function sortNameZA(a, b) {
  return (-1)*sortNameAZ(a,b);
}
function sortPrice1(a, b) {
  if(a.price==null){return -1;}
    if(b.price==null){return 1;}
  return a.price-b.price;
}
function sortPrice2(a, b) {
  return (-1)*sortPrice1(a, b);
}
///////////////////////sort///////////////////////////

async function getProductsList(page) {

  var linkGetProducts='http://localhost:9999/products/findByCategory/'+CATEGORY_ID;
  if(CATEGORY_ID==0){
    linkGetProducts='http://localhost:9999/products';
  }

  await fetch(linkGetProducts)
    .then(response => response.json())
    .then(async products => {
      switch(SORT_OPTION){
          case 1: products.sort(sortPrice1); break;
          case 2: products.sort(sortPrice2); break;
          case 3: products.sort(sortNameAZ); break;
          case 4: products.sort(sortNameZA); break;
        }
      const ul = document.querySelector('.mt-productlisthold-list-inline');
      ul.innerHTML = '';



        const totalProducts = products.length;
        if(PAGE_LIMIT==0){
           PAGE_LIMIT=totalProducts;
        }
          const offset = (page - 1) * PAGE_LIMIT;
          const start = offset + 1;
            var end = start + PAGE_LIMIT - 1;
            if (end > products.length) {
              end = products.length;
            }
        renderPagination(totalProducts,page);
        const pOffset = document.getElementById('p-offset');
        pOffset.innerHTML = `Showing <strong><span id="span-start">${start}</span>–<span id="span-end">${end}</span></strong> of <strong>${totalProducts}</strong> results`;


      for(let i = offset ; i < offset+PAGE_LIMIT && i<products.length; i++) {
              const product = products[i];
        await fetch('http://localhost:9999/images/'+product.id)
          .then(response => response.json())
          .then(async images => {
            if (images.length > 0) {
              const image = images[0].image.replaceAll(" ", "%20");
              const html = `<li>
                              <div id="alert-parent${product.id}" class="alert-parent mt-product1 large">
                                <div class="box">
                                  <div class="b1">
                                    <div class="b2">

                                      <a href="/products/detail?id=${product.id}"><img src='/images/product/${image}' alt="image description"></a>
                                        ${SPAN_SALE()}
                                      <ul class="mt-stars">
                                        <li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li>
                                      </ul>
                                      <ul class="links">
                                        <li><a id="addToCartBtn" href="#" onclick="handleAddToCart(event,${product.id},'${product.name}',${product.price},'${image}')"><i class="icon-handbag"></i><span>Add to Cart</span></a></li>
                                        <li><a href="#"><i class="icomoon icon-heart-empty"></i></a></li>
                                        <li><a href="#"><i class="icomoon icon-exchange"></i></a></li>
                                      </ul>
                                    </div>
                                  </div>
                                </div>
                                <div class="txt">
                                  <strong class="title"><a href="#">${product.name}</a></strong>
                                  <span class="price"><span> ${formatCurrency(product.price)}</span></span>
                                </div>
                              </div>
                            </li>`;
                await ul.insertAdjacentHTML('beforeend', html);
            }
          });
          }

    })
    .catch(error => {
      console.log(error);
    });
}

view91827All();
getProductsList(1);
//////////////////////View 9 19 27 All/////////////////////////
function view91827All(){
    const alist = document.querySelectorAll('#p-perpage a');
    alist.forEach(a => {
      a.onclick = null;
      a.onclick= function() {
        const activeLink = document.querySelector('.mt-pagination-active');
        var pageLimit = 0;
        try {
          if (!isNaN(parseInt(a.innerText))) {
            pageLimit = parseInt(a.innerText);
          }
        } catch (error) {
          // Xử lý khi có lỗi xảy ra trong quá trình chuyển đổi
          console.log('Error occurred:', error);
        }

        PAGE_LIMIT=pageLimit;
        getProductsList(1);
      };
    });
}

//////////////////////////////////Pagination///////////////////////////////
function renderPagination(totalProducts, currentPage) {
  const nav = document.querySelector('.mt-pagination');
  nav.innerHTML = '';

  const totalPages = Math.ceil(totalProducts / PAGE_LIMIT);

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
        getProductsList(page);
      });

    li.appendChild(link);
    ul.appendChild(li);
  }

  nav.appendChild(ul);
}


/////////////////////////RAND HOT SALE///////////////////////////
getProductsHome('#rand-hot-sale');
function getProductsHome(idtab) {
  var linkGetProducts = 'http://localhost:9999/products/home/3';
  var tabsSlider = document.querySelector(idtab);
  tabsSlider.innerHTML='';

  fetch(linkGetProducts)
    .then(response => response.json())
    .then(products => {
      var slideCount = 0; // Số lượng slide đã tạo
      var chan=0;
      var imagePromises = []; // Mảng chứa các promise của việc tải ảnh

      products.forEach((product, index) => {
        const imagePromise = fetch('http://localhost:9999/images/' + product.id)
          .then(response => response.json())
          .then(images => {
            if (images.length > 0) {
              const image = images[0].image.replaceAll(" ", "%20");
              const productHtml = `<div id="alert-parent${product.id}" class="alert-parent mt-product4 mt-paddingbottom2">
                <div class="img">
                  <a href="/products/detail?id=${product.id}"><img src='/images/product/${image}' alt="image description"></a>
                </div>
                <div class="text">
                    <div class="frame">
                        <strong><a href="/products/detail?id=${product.id}">${product.name}</a></strong>

                          <ul class="mt-stars">
                            <li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li>
                          </ul>
                    </div>
                    <del class="off">${formatCurrency(round1000(2.5*product.price))}</del>
                    <span class="price">${formatCurrency(product.price)}</span>
                  </div>
                </div>
              `;

              imagePromises.push(
                imagePromise.then(() => {
                  tabsSlider.insertAdjacentHTML('beforeend', productHtml);
                })
              );
            }
          });

      });

      return Promise.all(imagePromises);
    })
    .then(() => {
      // All images have been loaded and HTML is rendered correctly
    })
    .catch(error => {
      // Handle any errors that occurred during the fetch requests or rendering
      console.error(error);
    });
}

///////////////////////////////////////////////
async function getProductsListSearch(search) {
  const page = 1;
  var pageLimitt=0;
  var linkGetProducts = 'http://localhost:9999/products/findByCategory/' + CATEGORY_ID;
  if (CATEGORY_ID == 0) {
    linkGetProducts = 'http://localhost:9999/products';
  }

  await fetch(linkGetProducts)
    .then(response => response.json())
    .then(async products => {
      const ul = document.querySelector('.mt-productlisthold-list-inline');
      ul.innerHTML = '';

      const filteredProducts = products.filter(product => product.name.toLowerCase().includes(search.toLowerCase()));

      const totalProducts = filteredProducts.length;
      if (pageLimitt == 0) {
        pageLimitt = totalProducts;
      }
      const offset = (page - 1) * pageLimitt;
      const start = offset + 1;
      var end = start + pageLimitt - 1;
      if (end > filteredProducts.length) {
        end = filteredProducts.length;
      }

      renderPagination(totalProducts, page);
      const pOffset = document.getElementById('p-offset');
      pOffset.innerHTML = `Showing <strong><span id="span-start">${start}</span>–<span id="span-end">${end}</span></strong> of <strong>${totalProducts}</strong> results`;

      for (let i = offset; i < offset + pageLimitt && i < filteredProducts.length; i++) {
        const product = filteredProducts[i];
        await fetch('http://localhost:9999/images/' + product.id)
          .then(response => response.json())
          .then(async images => {
            if (images.length > 0) {
              const image = images[0].image.replaceAll(" ", "%20");
              const html = `<li>
                              <div id="alert-parent${product.id}" class="alert-parent mt-product1 large">
                                <div class="box">
                                  <div class="b1">
                                    <div class="b2">
                                      <a href="/products/detail?id=${product.id}"><img src='/images/product/${image}' alt="image description"></a>
                                      ${SPAN_SALE()}
                                      <ul class="mt-stars">
                                        <li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li><li><i class="fa fa-star"></i></li>
                                      </ul>
                                      <ul class="links">
                                        <li><a id="addToCartBtn" href="#" onclick="handleAddToCart(event,${product.id},'${product.name}',${product.price},'${image}')"><i class="icon-handbag"></i><span>Add to Cart</span></a></li>
                                        <li><a href="#"><i class="icomoon icon-heart-empty"></i></a></li>
                                        <li><a href="#"><i class="icomoon icon-exchange"></i></a></li>
                                      </ul>
                                    </div>
                                  </div>
                                </div>
                                <div class="txt">
                                  <strong class="title"><a href="#">${product.name}</a></strong>
                                  <span class="price"><span> ${formatCurrency(product.price)}</span></span>
                                </div>
                              </div>
                            </li>`;
              await ul.insertAdjacentHTML('beforeend', html);
            }
          });
      }
    })
    .catch(error => {
      console.log(error);
    });
}
