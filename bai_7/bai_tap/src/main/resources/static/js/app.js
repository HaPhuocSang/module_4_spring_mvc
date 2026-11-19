
(() => {

    const modal = document.getElementById("deleteModal");

    if (!modal) {
        return;
    }

    let targetForm = null;

    const message = document.getElementById("deleteMessage");

    // Đóng Modal
    const closeModal = () => {

        modal.classList.remove("show");

        targetForm = null;
    };

    // Khi nhấn nút Xóa
    document.querySelectorAll(".js-delete").forEach(button => {

        button.addEventListener("click", () => {

            // Lấy form tương ứng
            targetForm = document.getElementById(
                button.dataset.form
            );

            // Lấy tên bài viết hoặc danh mục
            const name = button.dataset.name || "mục này";

            // Hiển thị nội dung xác nhận
            message.textContent =
                `Bạn có chắc chắn muốn xóa "${name}" không? Hành động này không thể hoàn tác.`;

            // Hiển thị Modal
            modal.classList.add("show");

        });

    });

    // Nhấn Hủy
    document.getElementById("cancelDelete")
        .addEventListener("click", closeModal);

    // Nhấn Xác nhận xóa
    document.getElementById("confirmDelete")
        .addEventListener("click", () => {

            if (targetForm) {

                targetForm.submit();

            }

        });

    // Nhấn ra ngoài Modal
    modal.addEventListener("click", event => {

        if (event.target === modal) {

            closeModal();

        }

    });

    // Nhấn phím ESC
    document.addEventListener("keydown", event => {

        if (event.key === "Escape") {

            closeModal();

        }

    });

})();
