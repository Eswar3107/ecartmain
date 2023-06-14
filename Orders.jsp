<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Catalog</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            margin-top: 40px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .order-container {
            margin-bottom: 30px;
        }

        .order-header {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
        }

        .product-card {
            max-width: 250px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: box-shadow 0.3s;
            cursor: pointer;
            margin-bottom: 20px;
        }

        .product-card:hover {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .product-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .product-details {
            padding: 10px;
        }

        .product-title {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
        }

        .product-description {
            font-size: 14px;
            margin-bottom: 10px;
            color: #666;
        }

        .product-price {
            font-size: 14px;
            font-weight: bold;
            color: #e91e63;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Product Catalog</h2>
        <c:forEach var="order" items="${orderProducts}">
            <div class="order-container">
                <div class="order-header">Order ID: ${order.getOrdId()}</div>
                <div class="row">
                    <c:forEach var="product" items="${orderProducts}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card product-card">
                                <img class="card-img-top" src="${product.getImageUrl()}" alt="${product.getName()}">
                                <div class="product-title">${product.getName()}</div>
                                <div class="product-details" style="display: none;">
                                    
                                    <div class="product-description">${product.getDescription()}</div>
                                    <div class="product-price">${product.getPrice()}</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.product-card').click(function () {
                $(this).find('.product-details').slideToggle();
            });
        });
    </script>
</body>
</html>
