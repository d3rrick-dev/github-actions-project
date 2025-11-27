# Payment App

A sample Java Spring Boot payment application with a **modern CI/CD pipeline**, containerization, and security-focused best practices.

---

## Project Overview

This project demonstrates:

- Building a **Spring Boot Java application** using Maven.
- Automating **CI/CD pipelines** with **GitHub Actions**.
- Containerizing the application using **Docker**.
- Implementing **security scanning** for both code and Docker images.
- Ensuring high-quality code with **static analysis tools**.

The main goal is to showcase end-to-end automation from code commit to secure Docker image deployment.

---

## Features Implemented

### 1. CI/CD Pipeline

Using **GitHub Actions**, the project implements:

- **Build & Test:** Maven build, unit tests, Checkstyle, SpotBugs.
- **Dependency Security Scanning:** OWASP Dependency Check (SARIF reports uploaded to GitHub Security tab).
- **Artifact Management:** Built JAR artifacts and code quality reports are uploaded as GitHub Actions artifacts.

### 2. Docker Containerization

- Dockerfile using **Eclipse Temurin JDK 21**.
- Dockerfile linting with **Hadolint** to enforce best practices.
- Multi-stage Docker builds (if extended) possible.
- CI workflow builds Docker images and pushes to **GitHub Container Registry (GHCR)**.

### 3. Docker Image Security

- **Trivy vulnerability scanning** on the built image.
- Pipeline fails automatically if **CRITICAL** or **HIGH** vulnerabilities are detected.
- Trivy scan results uploaded to GitHub Security tab (SARIF format) for visibility.

### 4. Pipeline Flow

1. **Build Job**
    - Checkout code, set up JDK, cache Maven dependencies.
    - Run Checkstyle & SpotBugs.
    - Build JAR with Maven.
    - Run unit tests.
    - Run OWASP Dependency Check.
    - Upload build artifacts and code quality reports.

2. **Docker Job**
    - Download build artifacts.
    - Lint Dockerfile with Hadolint.
    - Build Docker image.
    - Run Trivy scan for vulnerabilities.
    - Push image to GHCR only if the scan passes.

---

## Technology Stack

- **Java 21** + Spring Boot
- **Maven** for build automation
- **Docker** for containerization
- **GitHub Actions** for CI/CD
- **Hadolint** for Dockerfile linting
- **Trivy** for Docker image vulnerability scanning
- **OWASP Dependency Check** for dependency security
- **Checkstyle & SpotBugs** for code quality

---

## Key Takeaways & Skills Demonstrated

- Designing **robust CI/CD pipelines** with multiple jobs and artifact handling.
- Implementing **automated security scanning** for code and container images.
- Writing **production-ready Dockerfiles** and enforcing best practices.
- Automating **fail-on-vulnerability logic** to prevent insecure artifacts from being published.
- Showcasing **full-stack DevOps practices** for Java applications.
- Uploading **SARIF reports** to GitHub Security tab for visibility and compliance.

---
