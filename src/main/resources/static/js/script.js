$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();

	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;
			});
		} else{
			checkbox.each(function(){
				this.checked = false;
			});
		}
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
$('#sendItemModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget)
  var id = button.data('itemid')
  var modal = $(this)
  modal.find('.modal-body .id').val(id)
});
$('#moveItemModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget)
  var id = button.data('itemid')
  var place = button.data('place')
  var modal = $(this)
  modal.find('#from').text(place)
  modal.find('.modal-body .id').val(id)
});
$('#editItemModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget)
  var id = button.data('id')
  var title = button.data('title')
  var serial = button.data('serial')
  var comments = button.data('comments')
  var place = button.data('place')
  var modal = $(this)
  modal.find('#id').val(id)
  modal.find('#title').val(title)
  modal.find('#serial').val(serial)
  modal.find('#comments').val(comments)
  modal.find('#place').val(place)
});
function popup(url, title, w, h) {
  var left = (screen.width/2)-(w/2);
  var top = (screen.height/2)-(h/2);
  return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
};
