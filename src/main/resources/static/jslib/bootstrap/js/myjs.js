/**
 * Created by Hubrt on 2016/6/20.
 */

//全局变量
var opts = {
    container: 'epiceditor',
    textarea: null,
    basePath: 'epiceditor',
    clientSideStorage: true,
    localStorageName: 'epiceditor',
    useNativeFullscreen: true,
    parser: marked,
    file: {
        name: 'epiceditor',
        defaultContent: '',
        autoSave: 100
    },
    theme: {
        base: '/themes/base/epiceditor.css',
        preview: '/themes/preview/preview-dark.css',
        editor: '/themes/editor/epic-dark.css'
    },
    button: {
        preview: true,
        fullscreen: true,
        bar: "auto"
    },
    focusOnLoad: false,
    shortcut: {
        modifier: 18,
        fullscreen: 70,
        preview: 80
    },
    string: {
        togglePreview: 'Toggle Preview Mode',
        toggleEdit: 'Toggle Edit Mode',
        toggleFullscreen: 'Enter Fullscreen'
    },
    autogrow: false
}
var editor = new EpicEditor(opts); // 全局EpicEditor

$(document).ready(function () {
    //默认加载富文本
    $('#summernote').summernote({
        height: 300,                 // set editor height
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true,                  // set focus to editable area after initializing summernote

        placeholder: 'article main here',

    });

   


});
//初始化 富文本编辑器
function initSummernote() {
    //先隐藏markdow编辑器
    editor.unload();
    $('#markdown_editer_main').addClass('hidden');
    //改变编辑器链接颜色
    $('#Markdown_inter').removeClass('editer_chosen');
    $('#Summernote_inter').addClass('editer_chosen');
    //编辑器开始工作
    $('#summernote').summernote({
        height: 300,                 // set editor height
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true,                  // set focus to editable area after initializing summernote

        placeholder: 'article main here',

    });

}
// 初始化 Markdown编辑器
function initMarkdownJS() {
    //先隐藏富文本编辑器
    $('#summernote').summernote('destroy');
    //选中Markdown编辑器
    $('#Summernote_inter').removeClass('editer_chosen');
    $('#Markdown_inter').addClass('editer_chosen');
    //去掉隐藏样式
    $('#markdown_editer_main').removeClass('hidden');
    //Markdown开始工作
    editor.load();  // 如何销毁/隐藏


}


// 取富文本编辑器的值
function getSummernoteValue() {
    var SummerValue = $('#summernote').summernote('code')
    alert(SummerValue);
}


//随便水水的文本编辑器
function initSingleWriter(){
    $('.acticle_create_main_modal1_writer').removeClass('hidden');
}
