function buy(){
const username=kiemtradangnhap();
if(!username){
alert('Please login!');
addClassToBody('side-col-active');
return;
}
    restoreCartItemsFromLocalStorage();
     var order_data={
        customer_id: 1,
        total:Cart.getTotalPrice(),
        username: username
     };
     fetch('http://localhost:9999/orders', {
         method: "POST",
         headers: {
           "Content-Type": "application/json"
         },
         body: JSON.stringify(order_data)
       }).then(response => {

         if (response.ok) {
           return response.json();
            }
            else {
                       throw new Error("Add order failed");
                     }
            })
            .then(order=>{
            console.log(order);


           Cart.cartItems.forEach(cartItem=>{
                const item={
                    quantity: cartItem.quantity,
                    order_id: order.id,
                    product_id: cartItem.id
                };
                fetch('http://localhost:9999/orderdetails', {
                         method: "POST",
                         headers: {
                           "Content-Type": "application/json"
                         },
                         body: JSON.stringify(item)
                       }).then(response => {

                          if (response.ok) {
                          console.log(response.json());
                          Cart.cartItems.splice(0, Cart.cartItems.length);
                            saveCartItemsToLocalStorage();
                          cartItemCountSpan.innerHTML = Cart.cartItems.length;
                          alert("Đặt hàng thành công");
                          }
                          else {
                            throw new Error("Add order detail failed");
                          }
                        }).catch(error => {

                                  console.log(error);
                        });

           });



       }).catch(error => {

                 console.log(error);
       });

}