var MenuItems = document.getElementById('MenuItems');
            MenuItems.style.maxHeight = '0px';


            function menutoggle() {
                if (MenuItems.style.maxHeight == '0px') {
                    MenuItems.style.maxHeight = '200px';
                } else {
                    MenuItems.style.maxHeight = '0px';
                }
            }

            function toggleDropdown() {
                var dropdownContent = document.getElementById("userDropdownContent");
                dropdownContent.style.display = (dropdownContent.style.display === "block") ? "none" : "block";
            }
