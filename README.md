# Enterprise Storage Application

A scalable backend storage platform built with Spring Boot and MinIO that provides secure object storage, metadata management, checksum validation, and enterprise-grade file handling capabilities.

---

## Overview

Enterprise Storage Application is designed to manage digital assets efficiently by combining object storage with metadata persistence.

The system supports file uploads, downloads, metadata tracking, integrity verification, and storage optimization while following clean architecture principles.

---

## Features

### Storage Operations

- Upload Files
- Download Files
- Delete Files
- Retrieve File Metadata
- Object Storage Integration

### Metadata Management

- Store File Metadata
- File Type Detection
- Upload Timestamp Tracking
- File Size Tracking
- User Attribution Support

### Data Integrity

- SHA-256 Checksum Generation
- Duplicate Detection Ready
- Integrity Verification

### Performance

- ETag Support
- Optimized File Retrieval
- Efficient Metadata Queries

### Architecture

- Controller Layer
- Service Layer
- Repository Layer
- DTO-Based Communication
- Global Exception Handling

---

## Technology Stack

### Backend

- Java 21
- Spring Boot 3
- Spring Web
- Spring Validation

### Database

- MongoDB

### Object Storage

- MinIO
- AWS S3 SDK v2

### Documentation

- Swagger OpenAPI

### Build Tool

- Maven

---

## System Architecture

Client
│
▼
REST API
│
▼
Controllers
│
▼
Services
│
▼
Storage Layer
├── MinIO
└── MongoDB

---

## Project Structure

src/main/java

├── config
├── controller
├── dto
├── entity
├── repository
├── service
│ └── impl
├── exception
├── util
└── validator

---

## Core Components

### Object Storage Service

Responsible for:

- Uploading files
- Downloading files
- Deleting files
- Managing object operations

### Metadata Service

Responsible for:

- Metadata persistence
- Search operations
- Metadata retrieval
- File tracking

### Validation Layer

Responsible for:

- Upload validation
- File size checks
- Content type validation
- Request verification

---

## Implemented APIs

### File APIs

| Method | Endpoint | Description |
|----------|----------|------------|
| POST | /files/upload | Upload File |
| GET | /files/{id} | Download File |
| DELETE | /files/{id} | Delete File |
| GET | /files/metadata/{id} | Get Metadata |

### Metadata APIs

| Method | Description |
|----------|------------|
| GET | Search Metadata |
| GET | Count Metadata |
| GET | Filter By File Type |
| GET | Filter By Status |

---

## Metadata Model

The application tracks:

- Original Filename
- Stored Filename
- Content Type
- File Size
- Upload Timestamp
- Checksum
- ETag
- Status

---

## Security & Integrity

### SHA-256 Checksum

Each uploaded file generates a checksum used for:

- Integrity Verification
- Corruption Detection
- Duplicate Prevention

### ETag Support

ETags are maintained to:

- Improve Caching
- Reduce Bandwidth Usage
- Support Conditional Requests

---

## Future Enhancements

- JWT Authentication
- Role-Based Access Control
- Presigned URLs
- Multipart Uploads
- File Versioning
- Soft Delete
- Restore Operations
- Audit Logging
- Monitoring Dashboard
- Kubernetes Deployment

---

## Learning Outcomes

This project helped strengthen understanding of:

- Spring Boot Architecture
- Object Storage Systems
- MinIO Integration
- MongoDB Data Modeling
- REST API Design
- Metadata Management
- Enterprise Backend Development
- Exception Handling Strategies

---

## Author

Pratham Garg

Backend Developer | Java | Spring Boot | Cloud Storage

GitHub: https://github.com/150202-Pratham

---

## Status

Current Phase: Core Storage Platform Development

Completed:
- File Upload
- File Download
- Metadata Persistence
- Checksum Validation
- ETag Tracking
- Exception Handling

In Progress:
- Advanced Search
- Storage Optimization
- Lifecycle Management
