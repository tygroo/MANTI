$(document).ready(function() {

	// Si le navigateur ne prend pas en charge le placeholder
	if (document.createElement('input').placeholder == undefined) {

		// Champ avec un attribut HTML5 placeholder
		$('[placeholder]')
		// Au focus on clean si sa valeur équivaut à celle du placeholder
		.focus(function() {
			if ($(this).val() == $(this).attr('placeholder')) {
				$(this).val('');
				$(this).css('color', '000');
//				if ($(this).attr('placeholder').toLowerCase()=="password"){
//					$(this).attr('type','password');
//				}
			}
		})
		// Au blur on remet le placeholder si le champ est laissé vide
		.blur(function() {
			if ($(this).val() == '') {
				$(this).val($(this).attr('placeholder'));
				$(this).css('color', '#888');
//				if ($(this).attr('placeholder').toLowerCase()=="password"){
//					$(this).attr('type','text');
//				}
			}
		})
		// On déclenche un blur afin d'initialiser le champ
		.blur()
		// Au submit on clean pour éviter d'envoyer la valeur du placeholder
		.parents('form').submit(function() {
			$(this).find('[placeholder]').each(function() {
				if ($(this).val() == $(this).attr('placeholder')) {
					$(this).val('');
//					if ($(this).attr('placeholder').toLowerCase()=="password"){
//						$(this).attr('type','password');
//					}
				}
			});
		});
	}

});