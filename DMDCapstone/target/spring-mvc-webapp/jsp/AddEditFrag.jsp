<!-- Modal stuff -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
     aria-labelledby="detailsModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="detailsModalLabel">Add a New Post</h4>
            </div>
            <div class="modal-body">
                <h2>Add A New Post</h2>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="add-title" class="col-md-4 control-label">Title: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="add-title" name="title"/>
                        </div> 
                    </div>
                    <div class="form-group">
                        <label for="addContentBody" class="col-md-4 control-label">Content: </label>
                        <div class="col-md-8">
                            <textarea class="form-control" id="addContentBody" name="content"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-tags" class="col-md-4 control-label">Tags: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="add-tags" name="tags" placeholder="Please put a space between tags"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" id="add-button" class="btn btn-info" data-dismiss="modal">Post</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>
                   
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
     aria-labelledby="detailsModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="detailsModalLabel">Edit Post</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label for="edit-title" class="col-md-4 control-label">
                            Title:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-title"
                                   placeholder="Title"></div></div>

                    <div class="form-group">
                        <label for="editContentBody" class="col-md-4 control-label">Content: </label>
                        <div class="col-md-8">
                            <textarea class="form-control" id="editContentBody" name="content"></textarea>
                        </div>
                    </div>

                    <div class="form-group"><label for="edit-tags"class="col-md-4 control-label">
                            Tags:</label>
                        <div class="col-md-8">
                            <input type="text"class="form-control"id="edit-tags">
                        </div>
                    </div>

                    <input type="hidden" id="edit-post-id">
                    <button type="submit"id="edit-button" class="btn btn-info" data-dismiss="modal">Save Changes</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>
