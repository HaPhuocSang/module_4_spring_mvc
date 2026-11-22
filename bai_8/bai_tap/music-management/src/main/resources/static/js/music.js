const deleteModal = document.getElementById("deleteModal");
if (deleteModal) {
    deleteModal.addEventListener("show.bs.modal", function (event) {
        const button = event.relatedTarget;
        const musicId = button.getAttribute("data-id");
        const musicName = button.getAttribute("data-name");
        document.getElementById("musicId").value = musicId;
        document.getElementById("musicName").textContent = musicName;
    });
}
