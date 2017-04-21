/**
 * Created by Administrator on 2017/4/21.
 */
/*
 *  StringUtil
 */
if (typeof String.prototype.startsWith != 'function') {
    String.prototype.startsWith = function (prefix) {
        return this.slice(0, prefix.length) === prefix;
    };
}

if (typeof String.prototype.endsWith != 'function') {
    String.prototype.endsWith = function (suffix) {
        return this.indexOf(suffix, this.length - suffix.length) !== -1;
    };
}

function replaceLastMatched(str, before, after) {
    var temp = str.substring(0, orderValue.lastIndexOf(before)); //获取到最后一个'desc'前面的字符串。
    str = temp + after;
    return str;
}