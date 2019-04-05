<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>welcome page</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    </head>

    <body>
        <table>
            <tr>
                <td><img src="images/20181027000713.jpg" height="200" width="200"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><hr />
                </td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td><a>亚洲</a>
                            </td>
                        </tr>
                        <tr>
                            <td><a>欧美</a>
                            </td>
                        </tr>
                        <tr>
                            <td><a>无码</a>
                            </td>
                        </tr>
                    </table></td>
                <td>
                <form action="/user/logout.do" method="post">
                    <table>
                        <tr>
                            <td colspan="2">登录成功!</td>
                        </tr>
                        <tr>
                            <td>欢迎你，</td>
                            <td>${username }</td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="退出" /></td>
                        </tr>
                    </table>
                </form></td>
            </tr>
        </table>
    </body>
</html>