function setColor(colorStr){
    $('.colorSet').css('background',colorStr);
    $('.content-list-box > .list-group-item').css('border-left','5px solid'+colorStr);
    console.log(colorStr);
}

function modalPopup(txt){
    $('.modal-content').html(txt);
    $('#modalBtn').trigger('click');
}