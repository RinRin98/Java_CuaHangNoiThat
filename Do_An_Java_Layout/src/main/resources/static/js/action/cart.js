//const CartItem ={
//    id: int,
//    name: string;
//    quantity: int,
//    price: long,
//    img: string
//};

// Đối tượng Giỏ Hàng
const Cart = {
  cartItems: [],


rowOne(cartItem){
    var img='/images/bg/img15.jpg';
    if(cartItem.img){
        img='/images/product/'+cartItem.img;
    }
    return `<div class="row border" id="rowOne${cartItem.id}">
                        <div class="col-xs-12 col-sm-2">
                          <div class="img-holder">
                            <img src="${img}" alt="image description">
                          </div>
                        </div>
                        <div class="col-xs-12 col-sm-4">
                          <strong class="product-name">${cartItem.name}</strong>
                        </div>
                        <div class="col-xs-12 col-sm-2">
                          <strong class="price">${formatCurrency(cartItem.price)}</strong>
                        </div>
                        <div class="col-xs-12 col-sm-2">
                                <div class="Z+JGL3">
                                    <button class="EquXA8" type="button" onclick="decrementQuantity(${cartItem.id})">-</button>
                                    <input class="EquXA8 Wrmraq" type="text" id="quantityInput${cartItem.id}" value="${cartItem.quantity}" readonly>
                                    <button class="EquXA8" type="button" onclick="incrementQuantity(${cartItem.id})">+</button>
                                </div>
                        </div>

                        <div class="col-xs-12 col-sm-2">
                          <strong id="priceOne${cartItem.id}" class="price">${formatCurrency(cartItem.quantity*cartItem.price)}</strong>
                          <a href="#" onclick="handleRemovecartItem(event,${cartItem.id})"><i class="fa fa-close"></i></a>
                        </div>
                      </div>`;
    },
findCartItemById(cartItemId) {
    return this.cartItems.find(cartItem => cartItem.id === cartItemId);
  },

  // Thêm sản phẩm vào Giỏ Hàng
  addcartItem(cartItem) {
    this.cartItems.push(cartItem);
    // Cập nhật giao diện
  },


  // Xóa sản phẩm khỏi Giỏ Hàng
  removecartItem(cartItemId) {
    this.cartItems = this.cartItems.filter(cartItem => cartItem.id !== cartItemId);
    // Cập nhật giao diện
  },

  // Cập nhật số lượng sản phẩm trong Giỏ Hàng
  updateQuantity(cartItemId, quantity) {
    this.cartItems.forEach(cartItem => {
      if (cartItem.id == cartItemId) {
        cartItem.quantity = quantity;
      }
    });
    // Cập nhật giao diện
  },

  // Tính tổng giá trị của Giỏ Hàng
  getTotalPrice() {
    let totalPrice = 0;
    this.cartItems.forEach(cartItem => {
      totalPrice += cartItem.price * cartItem.quantity;
    });
    return totalPrice;
  },
 getTotalPriceOne(cartItemId) {
   const cartItem= this.findCartItemById(cartItemId);
   if(cartItem){
   return cartItem.price * cartItem.quantity;
   }
   return 0;
 }
,

  // Cập nhật giao diện
  updateUI() {
    // Thực hiện cập nhật giao diện người dùng (DOM) tại đây
    // Ví dụ: cập nhật danh sách sản phẩm, hiển thị tổng giá trị, v.v.

  }
};

// Hàm xử lý sự kiện khi người dùng nhấn nút "Thêm vào Giỏ Hàng"
function handleAddToCart(event,cartItemId, name, price, img) {
    event.preventDefault();
    const existedCartItem=Cart.findCartItemById(cartItemId);
    if(existedCartItem){
        existedCartItem.quantity+=1;
    }
    else{
    const cartItem = {
        id: cartItemId,
        name: name,
        price: price,
        img: img,
        quantity: 1
      };

      // Thêm sản phẩm vào Giỏ Hàng
      Cart.addcartItem(cartItem);
      cartItemCountSpan.innerHTML = Cart.cartItems.length;
    }

    saveCartItemsToLocalStorage(); // Lưu giỏ hàng vào localStorage

    // Gọi hàm để hiển thị thông báo alert trong 1 giây và tự động đóng
    showAlertWithTimeout('alert-parent'+cartItemId,'Đã thêm', 500);
}
function handleAddToCartQ(event,cartItemId, name, price, img, quantity) {
    if(!quantity){
        handleAddToCart(event,cartItemId, name, price, img);
    }
    else{
        event.preventDefault();
        const existedCartItem=Cart.findCartItemById(cartItemId);
        if(existedCartItem){
            existedCartItem.quantity+=quantity;
        }
        else{
        const cartItem = {
            id: cartItemId,
            name: name,
            price: price,
            img: img,
            quantity: quantity
          };

          // Thêm sản phẩm vào Giỏ Hàng
          Cart.addcartItem(cartItem);
          cartItemCountSpan.innerHTML = Cart.cartItems.length;
        }

        saveCartItemsToLocalStorage(); // Lưu giỏ hàng vào localStorage

        // Gọi hàm để hiển thị thông báo alert trong 1 giây và tự động đóng
        showAlertWithTimeout('alert-parent'+cartItemId,'Đã thêm', 500);
    }

}

// Hàm xử lý sự kiện khi người dùng nhấn nút "Xóa sản phẩm"
function handleRemovecartItem(event, cartItemId) {
event.preventDefault();
  // Xóa sản phẩm khỏi Giỏ Hàng
 if(confirm('Delete cart item?')){
    Cart.removecartItem(cartItemId);
     saveCartItemsToLocalStorage(); // Lưu giỏ hàng vào localStorage
     const divrow = document.querySelector('#rowOne'+cartItemId);
     divrow.remove();
     updateTotal();
     cartItemCountSpan.innerHTML = Cart.cartItems.length;
 }

}

// Hàm xử lý sự kiện khi người dùng cập nhật số lượng sản phẩm
function handleUpdateQuantity(cartItemId, quantity) {
  // Cập nhật số lượng sản phẩm trong Giỏ Hàng
  Cart.updateQuantity(cartItemId, quantity);
  saveCartItemsToLocalStorage(); // Lưu giỏ hàng vào localStorage
  updateTotal();
  updateTotalOne(cartItemId);

}


function incrementQuantity(cartItemId) {
  const quantityInput = document.getElementById('quantityInput'+cartItemId);
  let quantity = parseInt(quantityInput.value);
  quantity++;
  quantityInput.value = quantity;
  handleUpdateQuantity(cartItemId,quantity);
}

function decrementQuantity(cartItemId) {
  const quantityInput = document.getElementById('quantityInput'+cartItemId);
  let quantity = parseInt(quantityInput.value);
  if (quantity > 1) {
    quantity--;
    quantityInput.value = quantity;
    handleUpdateQuantity(cartItemId,quantity);

  }
}
function updateTotal(){
    const spanElement1 = document.querySelector('.cartitems-get-total-price1');
    spanElement1.textContent = formatCurrency(Cart.getTotalPrice());
    const spanElement2 = document.querySelector('.cartitems-get-total-price2');
        spanElement2.textContent = formatCurrency(Cart.getTotalPrice());
}

function updateTotalOne(cartItemId){
    const spanElement1 = document.querySelector('#priceOne'+cartItemId);
    spanElement1.textContent = formatCurrency(Cart.getTotalPriceOne(cartItemId));
}
function showCart() {
  const tbl = document.querySelector('#mt-cart-item');
  var html = '';
  tbl.innerHTML = '';
  Cart.cartItems.forEach(cartItem => {
    html += Cart.rowOne(cartItem);
  });
  tbl.innerHTML = html;
  updateTotal();

}
// Lưu dữ liệu Cart.cartItems vào localStorage
function saveCartItemsToLocalStorage() {
  localStorage.setItem('cartItems', JSON.stringify(Cart.cartItems));
}

// Khôi phục dữ liệu từ localStorage khi tải lại trang
function restoreCartItemsFromLocalStorage() {
  const cartItems = localStorage.getItem('cartItems');
  if (cartItems) {
    Cart.cartItems = JSON.parse(cartItems);
  }
}

window.addEventListener('load', function() {
  restoreCartItemsFromLocalStorage();
 // Cập nhật giao diện giỏ hàng
});


function showAlertWithTimeout(divName,message, timeout) {
  const divElement = document.getElementById(divName);

    const alertElement = document.createElement('div');
    alertElement.classList.add('alert');
    alertElement.textContent = message;

    divElement.appendChild(alertElement);

  setTimeout(function() {
    alertElement.style.display = 'none';
  }, timeout);
}



