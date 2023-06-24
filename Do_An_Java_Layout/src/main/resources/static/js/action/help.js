function formatCurrency(currency){
    //var currency = 3500000;
    return currency.toLocaleString('en-US') + " VND";
    // Output: "3,500,000 VND"
}
function round1000(number){
    var roundedNumber = Math.round(number / 1000) * 1000;
    return roundedNumber;
}
function addClassToBody(className) {
  // Lấy phần tử body
  var body = document.body;

  // Thêm lớp mới vào phần tử body
  body.classList.add(className);
}
////////////////////////////////////////////////////////
const CHAIR="Experience the ultimate comfort with this stylish chair. Crafted with care and attention to detail, it offers a cozy and inviting seating option. The ergonomic design provides excellent support for your back and promotes good posture. Whether you're working, relaxing, or entertaining guests, this chair will enhance your space with its sleek and modern aesthetic. The high-quality materials used ensure durability and longevity, making it a worthwhile investment. Sit back, relax, and enjoy the luxurious comfort this chair has to offer.";
const TABLE="Add a touch of sophistication to your workspace with this elegant desk. Designed with both style and functionality in mind, it combines sleek lines with practical features. The spacious desktop provides ample space for your laptop, documents, and other essentials, while the built-in storage compartments keep your workspace organized and clutter-free. Crafted from high-quality materials, this desk is built to last and withstand the demands of daily use. Whether you're working from home or in an office setting, this desk offers a comfortable and inspiring environment to boost your productivity and creativity.";
const LIGHT="Illuminate your space with this stylish and functional light. Its contemporary design adds a modern touch to any room, while the adjustable feature allows you to direct the light exactly where you need it. Whether you're reading, working, or simply creating a cozy ambiance, this light provides the perfect lighting solution. Crafted with high-quality materials, it not only brightens up your space but also adds a touch of elegance. Enhance your home or office with this versatile light that combines both form and function.";
const CARPET="Transform your living space with this luxurious carpet. Its soft texture and eye-catching design create a warm and inviting atmosphere. Crafted with utmost care and attention to detail, this carpet adds comfort and style to any room. The durable construction ensures long-lasting beauty and functionality, while the non-slip backing provides stability and safety. Whether you want to define a seating area, add a pop of color, or create a cozy vibe, this carpet is the perfect choice to enhance your home decor.";
const BED="Experience ultimate comfort and relaxation with this exquisite bed. Its sleek and timeless design brings a touch of sophistication to your bedroom. Crafted with high-quality materials, this bed offers exceptional durability and support for a restful night's sleep. The spacious mattress provides ample space for you to unwind and recharge. With its elegant headboard and thoughtful details, this bed becomes the centerpiece of your bedroom, creating a serene and stylish retreat. Treat yourself to a luxurious sleeping experience with this exceptional bed.";
const KITCHEN="Elevate your culinary experience with this modern and functional kitchen. Designed with efficiency and style in mind, it offers a seamless blend of form and function. The well-organized layout and ample storage space ensure easy access to your cooking essentials. The high-quality materials and sturdy construction make it durable and long-lasting. Whether you're a gourmet chef or enjoy simple home-cooked meals, this kitchen provides a versatile and inspiring space to unleash your culinary creativity and make memorable moments.";
const SOFA="Relax and unwind in style with this elegant sofa. Its contemporary design and plush cushions create a cozy and inviting seating area in your living room. Crafted with comfort and durability in mind, this sofa offers ample space for you and your loved ones to lounge and enjoy quality time together. The premium upholstery and sturdy construction ensure long-lasting beauty and support. Whether you're entertaining guests, watching your favorite movie, or simply curling up with a book, this sofa provides the perfect combination of comfort and sophistication.";
const OTHER="Each product in our range is crafted with the utmost care and attention to detail, using high-quality materials to ensure durability and longevity. From sleek and modern designs to timeless classics, our products blend seamlessly with any decor style, making them versatile additions to your home or office. With our products, you can transform your spaces into inviting and inspiring environments. Whether you're entertaining guests, relaxing after a long day, or working from home, our products provide the perfect balance of functionality and style.";
function generate_title2(category){
    switch(category){
        case 'CHAIR': return CHAIR;
        case 'TABLE': return TABLE;
        case 'LIGHT': return LIGHT;
        case 'CARPET': return CARPET;
        case 'BED': return BED;
        case 'KITCHEN': return KITCHEN;
        case 'SOFA': return SOFA;
    }
    return OTHER;
}
///////////////////////////////////////////////////////////////
function SPAN_SALE() {
    const n = Math.floor(Math.random() * 100);
    const s = (1+Math.floor(Math.random() * 10)) * 5;// Ngẫu nhiên từ 5 đến 50
    const SPAN_START = '<span class="caption">';
    const SPAN1 = '<span class="off">' + s + '% Off</span>';
    const SPAN2 = '<span class="new">NEW</span>';
    const SPAN_END = '</span>';
    var RESULT = SPAN_START;
    if (n % 10 == 0) {
        RESULT +=  SPAN2;
    } else if (n % 5 == 0) {
        RESULT += SPAN1 +SPAN2;
    } else if (n % 4 == 0) {
        RESULT += SPAN1;
    }
    RESULT += SPAN_END;
    return RESULT;
}
