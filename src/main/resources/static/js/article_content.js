$(function () {
    editormd.markdownToHTML(
        "blog_content", {
            htmlDecode: "style,script,<iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析 // 默认不解析
        }
    )
});