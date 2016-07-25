<script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	Dropzone.options.dropZone = {
		paramName : "file",
		maxFilesize : 2,
		init : function() {
			var self = this;
			self.on("complete", function(file) {
				self.removeFile(file);
			});
		}
	}
</script>
<link rel="stylesheet"
	href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">

<form id="dropZone" action="../photo/upload" class="dropzone">
	<input type="text" class="hidden" name="fileName" />
</form>