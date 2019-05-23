/*
    示例：
    upload({
            // 上传控件ID
            id: "selectfiles",
            // 是否传多个文件
            mutil: true,
            // 上传文件类型
            mime_types: [{ title: "Image files", extensions: "jpg,gif,png,bmp" }],
            // 上传成功后回调函数
            callback: function (url) {
                $("#ossfile1").append('<img src="' + url + '" style="width:100px;height:100px;border:1px solid #eee;" />');
            },
   });
 */
function upload(obj) {
    obj.id = obj.id || "";
    obj.mutil = obj.mutil || false;
    obj.callback = obj.callback || function () { alert(arguments[0]); };
    obj.mime_types = obj.mime_types || [ //只允许上传图片和zip,rar文件
        {title: "图片文件", extensions: "jpg,gif,png,bmp"},
        {title: "文本文件", extensions: "pdf,doc,docx,pptx,ppt,DOC,DOCX,PPTX,PPT"},
        {title: "音频文件", extensions: "mp3"},
        {title: "视频文件", extensions: "mp4,wmv,mkv,rmvb,flv,mov"},
        {title: "压缩文件", extensions: "zip,rar"}
    ];

    //oss 上传路径
    var uploadUrl = '';
    var accessid = ''
    var accesskey = ''
    var host = ''
    var policyBase64 = ''
    var signature = ''
    var callbackbody = ''
    var filename = ''
    var key = ''
    var expire = 0
    var g_object_name = ''
    var g_object_name_type = ''
    var now = timestamp = Date.parse(new Date()) / 1000;

    function send_request() {
        var xmlhttp = null;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        if (xmlhttp != null) {
            serverUrl = "https://oss.rxjy.com/proj01/getOSSToken";
            xmlhttp.open("GET", serverUrl, false);
            xmlhttp.send(null);
            return xmlhttp.responseText
        }
        else {
            alert("Your browser does not support XMLHTTP.");
        }
    };

    function check_object_radio() {
        //var tt = document.getElementsByName('myradio');
        //for (var i = 0; i < tt.length; i++) {
        //    if (tt[i].checked) {
        //        g_object_name_type = tt[i].value;
        //        break;
        //    }
        //}
        g_object_name_type = "random_name";
    }

    function get_signature() {
        //可以判断当前expire是否超过了当前时间,如果超过了当前时间,就重新取一下.300s 做为缓冲
        now = timestamp = Date.parse(new Date()) / 1000;
        if (expire < now + 300) {
            body = send_request()
            var obj = eval("(" + body + ")");
            host = obj['uploadUrl']
            policyBase64 = obj['policy']
            accessid = obj['accessKey']
            signature = obj['signature']
            uploadUrl = obj['uploadUrl']
            //expire = parseInt(obj['expire'])
            //callbackbody = obj['callback']
            //key = obj['dir']+"/"
            key = "common/"
            return true;
        }
        return false;
    };

    function random_string(len) {
        len = len || 32;
        var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
        var maxPos = chars.length;
        var pwd = '';
        for (i = 0; i < len; i++) {
            pwd += chars.charAt(Math.floor(Math.random() * maxPos));
        }
        timestamp = Date.parse(new Date()) / 1000;
        return timestamp + pwd;
    }

    function get_suffix(filename) {
        alert(filename);
        pos = filename.lastIndexOf('.')
        suffix = ''
        if (pos != -1) {
            suffix = filename.substring(pos)
        }
        return suffix;
    }

    /**
     * 获取文件前缀
     * @param filename
     * @returns {string}
     */
    function get_suffix(filename) {
        pos = filename.lastIndexOf('.');
        suffix = ''
        if (pos != -1) {
            suffix = filename.substring(pos);
        }
        return suffix;
    }

    function calculate_object_name(filename) {
        if (g_object_name_type == 'local_name') {
            g_object_name += "${filename}"
        }
        else if (g_object_name_type == 'random_name') {
            suffix = get_suffix(filename)
            g_object_name = key + random_string(10) + suffix
        }
        return ''
    }

    function get_uploaded_object_name(filename) {
        if (g_object_name_type == 'local_name') {
            tmp_name = g_object_name
            tmp_name = tmp_name.replace("${filename}", filename);
            return tmp_name
        }
        else if (g_object_name_type == 'random_name') {
            return g_object_name
        }
    }

    function set_upload_param(up, filename, ret) {
        if (ret == false) {
            ret = get_signature()
        }
        g_object_name = key;
        if (filename != '') {
            suffix = get_suffix(filename)
            calculate_object_name(filename)
        }
        new_multipart_params = {
            'key': g_object_name,
            'policy': policyBase64,
            'OSSAccessKeyId': accessid,
            'success_action_status': '200', //让服务端返回200,不然，默认会返回204
            'callback': callbackbody,
            'signature': signature,
        };

        up.setOption({
            'url': host,
            'multipart_params': new_multipart_params
        });

        up.start();
    }

    var uploader = new plupload.Uploader({
        runtimes: 'html5,flash,silverlight,html4',
        browse_button: obj.id,// 选择按钮
        multi_selection: obj.mutil,
        //container: document.getElementById('container'),
        flash_swf_url: 'lib/plupload-2.1.2/js/Moxie.swf',
        silverlight_xap_url: 'lib/plupload-2.1.2/js/Moxie.xap',
        url: 'http://oss.aliyuncs.com',

        filters: {
            mime_types: obj.mime_types,
            max_file_size: '50mb', //最大只能上传10mb的文件
            prevent_duplicates: true //不允许选取重复文件
        },

        init: {
            PostInit: function () {},

            FilesAdded: function (up, files) {
                set_upload_param(uploader, '', false);
            },

            BeforeUpload: function (up, file) {
                check_object_radio();
                set_upload_param(up, file.name, true);
            },

            UploadProgress: function (up, file) {},

            FileUploaded: function (up, file, info) {

                if (info.status == 200) {
                    var imgUrl = uploadUrl + "/" + get_uploaded_object_name(file.name);
                    console.log(imgUrl);
                    // 回调函数
                    obj.callback(uploadUrl, "/" + get_uploaded_object_name(file.name),file.name, imgUrl, obj.id);
                }
                else {
                    console.log(info.response);
                    alert(info.response);
                }
            },

            Error: function (up, err) {
                var msg = "";
                if (err.code == -600) {
                    msg = "\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小";
                }
                else if (err.code == -601) {
                    msg = "\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型";
                }
                else if (err.code == -602) {
                    msg = "\n这个文件已经上传过一遍了";
                }
                else {
                    msg = "\nError xml:" + err.response;
                }
                console.log(msg);
                alert(msg);
            }
        }
    });
    uploader.init();
}