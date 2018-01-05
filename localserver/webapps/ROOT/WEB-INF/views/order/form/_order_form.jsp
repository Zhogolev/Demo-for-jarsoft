<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="/css/form.css" rel="stylesheet" type="text/css">

<html>
<body>
    <form method="post" action="/basket/order" enctype="application/x-www-form-urlencoded">
        <div class="name">NAME: <input name="name" placeholder="How should we call you" value=""></div>
        <div class="phone">PHONE:<input name="phone" type="tel" placeholder="+1-999-999-99-99" value=""/></div>
        <div class="submit"><button type="submit" name="action" value="accept">Accept</button></div>
        <div class="back"><button type="submit" name="action" value="back">Go back</button></div>
    </form>
</body>
</html>
