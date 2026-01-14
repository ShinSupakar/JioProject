# Electro Info: Hostel Block & Gadget Management System

## 📌 Overview

This Android app uses Firebase for login and data storage to display hostel block information and gadget usage. After logging in, users can select a hostel block to see basic statistics such as the number of students, registered gadgets, estimated electricity consumption, and calculated charges. The app also allows users to look up gadget details for individual rooms.

The application integrates Firebase authentication and real-time data with a fragment-based Android interface to manage hostel occupancy and gadget usage.

## 🚀 Application Flow

Splash Screen
↓<br>
User Authentication
↓<br>
Block Selection Dashboard
↓<br>
Tabbed Block & Gadget Information
↓<br>
Room-Level Gadget Details

## ⚙️ Features
### User Authentication

- Email and password–based login

- Password reset through email

- Authentication handled using Firebase

### Block Selection

- Displays hostel blocks in a scrollable list

- Each block opens a detailed view when selected

### Block Information

- Shows the number of students residing in the selected block

- Displays the total number of registered gadgets

- Calculates estimated maximum power consumption

- Calculates total charges based on predefined rules

### Gadget Information

- Allows room-based lookup

- Displays resident names and gadget counts

- Data is fetched in real time from Firebase

### Navigation and UI

- Tab-based layout for switching between block and gadget information

- Navigation drawer for logout and additional screens

- Simple and consistent UI structure


## 🧠 Technical Architecture

### UI Layer
- Activities for screen-level navigation
- Fragments for modular content display

### Data Layer
- Firebase Authentication
- Firebase Realtime Database

### Logic Layer
- RecyclerView adapters
- ViewPager and tab coordination
- Runtime calculations for analytics

## 📊 Data Handling & Logic

- Data is fetched from Firebase Realtime Database

- Calculations (student count, gadget count, consumption, billing) are performed at runtime

- The system uses rule-based logic rather than stored aggregates, ensuring consistency with live data

## 💻 Tech Stack

- Language: Kotlin

- Platform: Android

- UI: XML layouts, ViewBinding

- Backend: Firebase Realtime Database

- Authentication: Firebase Auth

- UI Components:
  - RecyclerView
  - ViewPager2
  - TabLayout
  - Navigation Drawer

