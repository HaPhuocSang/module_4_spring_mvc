// Xác nhận trước khi đặt hàng
function confirmCheckout() {
    return confirm(
        "Bạn có chắc chắn muốn xác nhận đặt hàng không?"
    );
}

// Tự động ẩn thông báo sau 5 giây
document.addEventListener("DOMContentLoaded", function () {

    const alerts = document.querySelectorAll(".alert");

    alerts.forEach(function (alert) {

        setTimeout(function () {

            const closeButton = alert.querySelector(".btn-close");

            if (closeButton) {
                closeButton.click();
            }

        }, 5000);

    });

});

function confirmOrder() {
    document.getElementById("checkoutForm").submit();
}