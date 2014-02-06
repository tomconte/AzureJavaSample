<%@page import="java.sql.Blob"%>
<%@page import="java.util.*"%>
<%@page import="org.azurejava.sample.*"%>
<%@page import="org.azurejava.sample.model.*"%>
<%@page language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Azure + Java</title>
	<link href="style.css" media="screen" type="text/css" rel="stylesheet" />
</head>
<body>

<jsp:useBean id="AlbumService" class="org.azurejava.sample.AlbumService" scope="page" />

<div id="albums">
<%
	List<DisplayAlbum> albums = AlbumService.getAlbumsForArtist("Led Zeppelin");
	Iterator<DisplayAlbum> i = albums.iterator();
	while (i.hasNext()) {
		DisplayAlbum a = i.next();
%>
	<div class="album">
		<div><%= a.hasCover() ? "<img class=\"albumcover\" src=\"" + a.getCover() + "\">" : "(no cover image)" %></div>
		<div><%= a.getTitle() %></div>
	</div>
<%
	}
%>
</div>

<div>
<%= BlobUtil.listContainers()  %>
</div>

</body>
</html>