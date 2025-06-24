<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
        }
        
        .content {
            padding: 20px;
        }
        
        .card {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        
        .card h2 {
            margin-top: 0;
        }
        
        .card p {
            line-height: 1.5;
        }
        
        .footer {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Welcome to the Dashboard</h1>
    </div>
    
    <div class="content">
        <div class="card">
            <h2>Overview</h2>
            <p>This is the dashboard page where you can access various features and tools of the application.</p>
        </div>
        
        <div class="card">
            <h2>Quick Actions</h2>
            <ul>
                <li><a href="#">Create New Report</a></li>
                <li><a href="#">View Notifications</a></li>
                <li><a href="#">Manage Settings</a></li>
            </ul>
        </div>
        
        <div class="card">
            <h2>Analytics</h2>
            <p>Here you can find various analytics and insights about your data.</p>
        </div>
    </div>
    
    <div class="footer">
        <p>&copy; 2024 My Application. All rights reserved.</p>
    </div>
</body>
</html>