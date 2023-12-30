function openFilePicker() {
    document.getElementById("profile-pic-input").click();
  }
  
  document.getElementById("profile-pic-input").onchange = function() {
    const file = this.files[0];
  
    if (file) {
      const reader = new FileReader();
  
      reader.onload = function() {
        document.getElementById("profile-pic").src = reader.result;
      };
  
      reader.readAsDataURL(file);
    }
  };