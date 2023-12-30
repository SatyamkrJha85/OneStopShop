/**========================================================================================================== */
// CORE JAVASCRIPT IS USED TO ADD CLASS

const siteLoad = (() => {
  const uiElements = [
    { selector: "#js-first-content", addClassName: "bounce" },
    { selector: "#js-second-content", addClassName: "swing" },
    { selector: "#js-features", addClassName: "swing" }
  ];

  const setNowAnimation = function(el, addClassName) {
    const windowHeight = window.innerHeight;
    const scrollTop = window.pageYOffset;
    const elementOffsetTop = el.offsetTop + 200;

    if (scrollTop + windowHeight > elementOffsetTop) {
      el.classList.add(addClassName);
      el.classList.add("animated");
    } else {
      el.classList.remove(addClassName);
      el.classList.remove("animated");
    }
  };
  return {
    getUiElements: function() {
      return uiElements;
    },
    setAnimation: function(el, addClassName) {
      setNowAnimation(el, addClassName);
    }
  };
})();

const siteController = (ui => {
  const elements = ui.getUiElements();
  const colFn = function() {
    elements.forEach(el => {
      return ui.setAnimation(
        document.querySelector(el.selector),
        el.addClassName
      );
    });
  };
  return {
    init: function() {
      colFn();
      window.onscroll = function() {
        colFn();
      };
    }
  };
})(siteLoad);

// DISABLED BELOW LINE SO THAT CORE JS NOT TRIGGERED.

//document.addEventListener("DOMContentLoaded", siteController.init, false);

/**========================================================================================================== */

// WAYPOINT JS IS USED TO TRIGGER CSS ANIMATION

$("#js-first-content").waypoint({
  handler: function(direction) {
    if (direction == "down") {
      $(this.element).addClass("bounce");
      $(this.element).addClass("animated");
    }
  },
  offset: "50%"
});

$("#js-second-content").waypoint({
  handler: function(direction) {
    if (direction == "down") {
      $(this.element).addClass("fadeIn");
      $(this.element).addClass("animated");
    }
  },
  offset: "50%"
});

$("#js-third-content").waypoint({
  handler: function(direction) {
    if (direction == "down") {
      $(this.element).addClass("fadeIn");
      $(this.element).addClass("animated");
    }
  },
  offset: "50%"
});

$("#js-fourth-content").waypoint({
  handler: function(direction) {
    if (direction == "down") {
      $(this.element).addClass("bounceInRight");
      $(this.element).addClass("animated");
    }
  },
  offset: "75%"
});

// $("#js-features").waypoint({
//   handler: function(direction) {
//     if (direction == "down") {
//       $(this.element).addClass("bounce");
//       $(this.element).addClass("animated");
//     }
//   },
//   offset: "75%"
// });

/**========================================================================================================== */
// Carasoul Starts

$(".client-carousel").owlCarousel({
  loop: true,
  margin: 10,
  nav: true,
  dots: false,
  responsive: {
    0: {
      items: 1
    },
    600: {
      items: 1
    },
    1000: {
      items: 1
    }
  },
  navText: [
    '<i class="im im-angle-left"></i>',
    '<i class="im im-angle-right"></i>'
  ]
});
