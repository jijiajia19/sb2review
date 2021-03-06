<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>多文件上传</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
</head>

<body>
<div>
    <div>
        <div>
            <h3>多个文件上传</h3>
        </div>
        <div>
            <form  method="post" enctype="multipart/form-data" action="/uploadMultiFile">
                <div>
                    <label for="attachment1">文件上传: </label>
                    <div>
                        <input type="file"  name="attachment" id="attachment1" placeholder="请选择邮件附件"/>
                    </div>
                </div>
                <div>
                    <label for="attachment2">文件上传: </label>
                    <div class="col-sm-5">
                        <input type="file"  name="attachment" id="attachment2" placeholder="请选择邮件附件"/>
                    </div>
                </div>
                <div>
                    <label for="attachment3">文件上传: </label>
                    <div>
                        <input type="file" name="attachment" id="attachment3" placeholder="请选择邮件附件"/>
                    </div>
                </div>

                <div>
                    <div>
                        <button type="submit">上&nbsp;传</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

</html>