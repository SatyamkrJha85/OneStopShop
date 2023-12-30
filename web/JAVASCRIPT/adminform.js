function previewImage(input) {
    const preview = document.getElementById('preview');
    const imagePreview = document.getElementById('image-preview');
    if (input.files && input.files[0]) {
        const reader = new FileReader();
        reader.onload = function (e) {
            preview.src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
        imagePreview.style.display = 'block';
    } else {
        preview.src = '';
        imagePreview.style.display = 'none';
    }
}
function openFilePicker() {
    document.getElementById("profile-pic-input").click();
}

document.getElementById("profile-pic-input").onchange = function () {
    const file = this.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function () {
            document.getElementById("profile-pic").src = reader.result;
        };

        reader.readAsDataURL(file);
    }
};