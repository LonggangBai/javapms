package com.javapms.basic.utils;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.ParserException;

public class StringBeanUtils {
    public static String handelUrl(String url) {
        if (url == null) {
            return null;
        }
        url = url.trim();
        if ((url.equals("")) || (url.startsWith("http://")) ||
                (url.startsWith("https://"))) {
            return url;
        }
        return "http://" + url.trim();
    }

    public static String[] splitAndTrim(String str, String sep, String sep2) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        if (!StringUtils.isBlank(sep2)) {
            str = StringUtils.replace(str, sep2, sep);
        }
        String[] arr = StringUtils.split(str, sep);

        int i = 0;
        for (int len = arr.length; i < len; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
    }

    public static boolean hasHtml(String txt) {
        if (StringUtils.isBlank(txt)) {
            return false;
        }
        boolean doub = false;
        int i = 0;
        if (i < txt.length()) {
            char c = txt.charAt(i);
            if (c == ' ') {
                if (doub) {
                    return true;
                }
                return true;
            }
            switch (c) {
                case '&':
                    return true;
                case '<':
                    return true;
                case '>':
                    return true;
                case '"':
                    return true;
                case '\n':
                    return true;
            }
            return false;
        }
        return false;
    }

    public static String txt2htm(String txt) {
        if (StringUtils.isBlank(txt)) {
            return txt;
        }
        StringBuilder sb = new StringBuilder((int) (txt.length() * 1.2D));

        boolean doub = false;
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (c == ' ') {
                if (doub) {
                    sb.append(' ');
                    doub = false;
                } else {
                    sb.append("&nbsp;");
                    doub = true;
                }
            } else {
                doub = false;
                switch (c) {
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    case '"':
                        sb.append("&quot;");
                        break;
                    case '\n':
                        sb.append("<br/>");
                        break;
                    default:
                        sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String textCut(String s, int len, String append) {
        if (s == null) {
            return null;
        }
        int slen = s.length();
        if (slen <= len) {
            return s;
        }
        int maxCount = len * 2;
        int count = 0;
        int i;
        for (i = 0; (count < maxCount) && (i < slen); i++) {
            if (s.codePointAt(i) < 256) {
                count++;
            } else {
                count += 2;
            }
        }
        if (i < slen) {
            if (count > maxCount) {
                i--;
            }
            if (!StringUtils.isBlank(append)) {
                if (s.codePointAt(i - 1) < 256) {
                    i -= 2;
                } else {
                    i--;
                }
                return s.substring(0, i) + append;
            }
            return s.substring(0, i);
        }
        return s;
    }

    public static String htmlCut(String s, int len, String append) {
        String text = html2Text(s, len * 2);
        return textCut(text, len, append);
    }

    public static String html2Text(String html, int len) {
        try {
            Lexer lexer = new Lexer(html);

            StringBuilder sb = new StringBuilder(html.length());
            Node node;
            while ((node = lexer.nextNode()) != null) {
                if ((node instanceof TextNode)) {
                    sb.append(node.toHtml());
                }
                if (sb.length() > len) {
                    break;
                }
            }
            return sb.toString();
        } catch (ParserException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringBuilder replace(StringBuilder sb, String what, String with) {
        int pos = sb.indexOf(what);
        while (pos > -1) {
            sb.replace(pos, pos + what.length(), with);
            pos = sb.indexOf(what);
        }
        return sb;
    }

    public static String replace(String s, String what, String with) {
        return replace(new StringBuilder(s), what, with).toString();
    }

    public static boolean contains(String str, String[] strs) {
        if ((strs == null) || (strs.length == 0)) {
            return false;
        }
        for (String s : strs) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.utils.StringBeanUtils

 * JD-Core Version:    0.7.0.1

 */