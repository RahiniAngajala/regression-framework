# 🧪 Regression Test Automation Framework (Spring Boot)

## 📌 Project Overview
This project is a **Regression Test Automation Framework** built using Spring Boot.  
It executes test cases in parallel, stores results in MySQL, and provides analytics through REST APIs.

---

## ⚙️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs
- Multithreading (ExecutorService)

---

## 🚀 Features

### ✅ Test Execution Engine
- Executes multiple test cases dynamically
- Uses multithreading for parallel execution
- Generates unique Run ID for each execution

### ✅ Result Management
- Stores PASS/FAIL results in MySQL database
- Captures execution time and error messages

### 📊 Analytics Module
- Total test cases executed
- Pass count
- Fail count
- Pass percentage
- Fail percentage

### 🔁 Run-wise Tracking
- Each execution has a unique Run ID
- Fetch results based on execution run

---

## 📡 API Endpoints

### ▶ Run Tests
## 📡 API Endpoints

### ▶ Run Tests
POST /api/execution/run

### ▶ Get All Results
GET /api/execution/results

### ▶ Failures
GET /api/execution/failures

### ▶ Summary
GET /api/execution/summary

### ▶ Run-wise Results
GET /api/execution/run/{runId}

### ▶ Analytics
GET /api/execution/analytics/summary
