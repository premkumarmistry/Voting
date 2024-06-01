# 📊 Voting Application

![Android](https://img.shields.io/badge/Platform-Android-green?logo=android)
![Java](https://img.shields.io/badge/Language-Java-blue?logo=java)
![Firebase](https://img.shields.io/badge/Backend-Firebase-orange?logo=firebase)
![MIT License](https://img.shields.io/github/license/premkumarmistry/Voting)

## Introduction

Welcome to the Voting Application repository! This Android application is designed to provide a secure and user-friendly platform for conducting elections. It leverages Firebase for backend services including authentication, real-time database, and storage.

## Features

- 🔒 **User Authentication**: Secure login and registration using Firebase Authentication.
- 🗳️ **Create Elections**: Admins can set up new elections with specific parameters.
- ✅ **Cast Votes**: Users can cast their votes through an intuitive interface.
- 📊 **Results Calculation**: Real-time vote counting and result display using Firebase Realtime Database.
- 🛠️ **Admin Dashboard**: Comprehensive dashboard for managing users and elections.

## Installation

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest version)
- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher)
- [Firebase Account](https://firebase.google.com/)

### Steps

1. **Clone the repository**:
   ```sh
   git clone https://github.com/premkumarmistry/Voting.git
   cd Voting
   ```

2. **Open the project in Android Studio**:
   - Launch Android Studio.
   - Select "Open an existing Android Studio project".
   - Navigate to the cloned directory and open it.

3. **Set up Firebase**:
   - Go to the [Firebase Console](https://console.firebase.google.com/).
   - Create a new project or use an existing one.
   - Add an Android app to your project and follow the setup steps.
   - Download the `google-services.json` file and place it in the `app` directory of your Android project.

4. **Configure Firebase**:
   - Open the `build.gradle` files (both project-level and app-level) and ensure you have the necessary Firebase dependencies added.
   - Sync your project with Gradle files.

5. **Run the application**:
   - Connect your Android device or start an emulator.
   - Click on the "Run" button in Android Studio to install and launch the app.

## Usage

1. **Register an account**: Sign up using the registration form within the app.
2. **Create a new election** (Admin only): Access the admin dashboard to set up a new election.
3. **Vote**: Login and select an active election to cast your vote.
4. **View results**: Results are displayed in real-time on the results page.

## Contributing

We welcome contributions to enhance the Voting Application. To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature-name`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or support, please contact:

- **Prem Kumar Mistry**: [premsahebrajmistry@gmail.com](mailto:premsahebrajmistry@gmail.com)
- **GitHub Issues**: Open an issue on the repository for bug reports or feature requests.

---
