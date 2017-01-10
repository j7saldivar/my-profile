$(document).ready(function() {
	
	$(window).scroll(function() {
	
		$('.hideme').each(function() {

				var halfOfObject = $(this).offset().top + $(this).outerHeight() / 2;
				var bottomOfWindow = $(window).scrollTop() + $(window).height();
		
				if (bottomOfWindow > halfOfObject) {

					$(this).show("slow");
					$(this).animate({'opacity' : '1'}, 1500);

				}

		});

	});

});