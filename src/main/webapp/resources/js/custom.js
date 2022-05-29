$(document).delegate('header .menu-btn','click',function(event){event.preventDefault();
jQuery('header nav').toggleClass('show');});
$(function(){$('[data-bs-toggle="tooltip"]').tooltip({container:'.page'});})