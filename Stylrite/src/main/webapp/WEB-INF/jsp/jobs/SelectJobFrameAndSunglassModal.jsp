<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client</title>
</head>
<body>
	<div class="modal fade bd-example-modal-lg" id="SelectJobFrameAndSunglassModal" tabindex="-1" role="dialog" aria-labelledby="SelectJobFrameAndSunglassModal" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      		 <jsp:include page="/WEB-INF/jsp/jobs/FrameAndSunglassList.jsp"/>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>