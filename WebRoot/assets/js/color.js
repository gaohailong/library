$(function(){
var btn = $('#sidebar-shortcuts-large').find('button');
	$(btn[0]).click(function(){
		$('body').removeClass().addClass('no-skin');
	});
	$(btn[1]).click(function(){
		$('body').removeClass().addClass('skin-1');
	});
	$(btn[2]).click(function(){
		$('body').removeClass().addClass('skin-2');
	});
	$(btn[3]).click(function(){
		$('body').removeClass().addClass('skin-3');
	});
});