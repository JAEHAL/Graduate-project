$("#primary a").click(function(){
			$("#primary a").removeClass("active");
			$(this).addClass("active");
			$("#Content div").css("display", "none");
			var tabname = $(this).text();
			tabname = tabname.replace(' ','');
			$("#"+tabname).css("display","block");
	 });