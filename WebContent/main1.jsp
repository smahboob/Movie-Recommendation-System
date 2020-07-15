<%@page import="com.org.Rating"%>
<%@page import="com.org.MovieDatabase"%>
<%@page import="com.org.RaterDatabase"%>
<%@page import="com.org.FirstRatings"%>
<%@page import="com.org.Filter"%>
<%@page import="com.org.GenreFilter"%>
<%@page import="com.org.AllFilters"%>
<%@page import="com.org.YearAfterFilter"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.org.FourthRatings"%>
<%@page import="com.org.EfficientRater"%>


<%@page import="com.org.Rater"%>
<%@page import="com.org.PlainRater"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="App2.css" rel="stylesheet" type="text/css">
<title>Your Ratings</title>
</head>
<body>

<%
MovieDatabase.initialize("ratedmoviesfull.csv");
RaterDatabase.initialize("ratings.csv");
AllFilters af = new AllFilters();
af.addFilter(new GenreFilter("Action"));
af.addFilter(new YearAfterFilter(2010));
ArrayList<String> arr = MovieDatabase.filterBy(af);
FourthRatings fourthRatings = new FourthRatings();
%>
	<h1>Movies Recommendations Based on your Ratings</h1>
      
      <% 
      RaterDatabase.addRaterRating("1500", arr.get(1),  Double.parseDouble(request.getParameter("movieOne")));
      RaterDatabase.addRaterRating("1500", arr.get(10), Double.parseDouble(request.getParameter("movieTwo")));
      RaterDatabase.addRaterRating("1500", arr.get(20), Double.parseDouble(request.getParameter("movieThree")));
      RaterDatabase.addRaterRating("1500", arr.get(30), Double.parseDouble(request.getParameter("movieFour")));
      RaterDatabase.addRaterRating("1500", arr.get(35), Double.parseDouble(request.getParameter("movieFive")));
      RaterDatabase.addRaterRating("1500", arr.get(40), Double.parseDouble(request.getParameter("movieSix")));
      RaterDatabase.addRaterRating("1500", arr.get(45), Double.parseDouble(request.getParameter("movieSeven")));
      RaterDatabase.addRaterRating("1500", arr.get(50), Double.parseDouble(request.getParameter("movieEight")));  
      RaterDatabase.addRaterRating("1500", arr.get(60), Double.parseDouble(request.getParameter("movieNine")));
      RaterDatabase.addRaterRating("1500", arr.get(23), Double.parseDouble(request.getParameter("movieTen")));    
      
      
      ArrayList<Rating> listAve= fourthRatings.getSimilarRatings("1500",5,3);
      System.out.println("Result Size: " + listAve);
      
      int numberToPrinted;
      
      if(listAve.size()==0){
          System.out.println("Sorry, there is no suitable movies to be recommened.");
          return;
      }else if(listAve.size() > 15){
          numberToPrinted = 15;
      }else {
          numberToPrinted = listAve.size();
      }
      
      %>
      
   <table style="width:100%">
   <tr>
    <th></th>
    <th>Year</th>
    <th>Movie Title</th> 
  </tr>
  <% for(int k=0; k < numberToPrinted; k++) { %>
  <tr>
  	<td><img src = <%out.println(MovieDatabase.getPoster(listAve.get(k).getItem()));%> alt = "Poster not found" style = "width:70px;height:90px;"></td>
  	<td><%out.println(MovieDatabase.getYear(listAve.get(k).getItem()));%></td>
  	<td><%out.println(MovieDatabase.getTitle(listAve.get(k).getItem()));%></td>
  </tr>
  <%} %>
  
  </table>
      
    
      
             

</body>
</html>