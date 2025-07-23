# Amnco Mobile Appium

This repository contains an automation testing framework for mobile applications using [Appium](https://appium.io/), designed to test native, hybrid, and mobile web applications on Android and iOS platforms. The framework is built to support scalable and maintainable test automation for the Amnco mobile application.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Desired Capabilities](#desired-capabilities)
- [Contributing](#contributing)


## Prerequisites

Before setting up the project, ensure you have the following installed:

- **Node.js and npm**: Required to install Appium. Download from [nodejs.org](https://nodejs.org/).
- **Java Development Kit (JDK)**: Version 17 or higher (e.g., Temurin distribution). Install via [Adoptium](https://adoptium.net/).
- **Android SDK**: Install via [Android Studio](https://developer.android.com/studio) or standalone.
  - Set `ANDROID_HOME` environment variable to the SDK path.
  - Add `%ANDROID_HOME%\tools`, `%ANDROID_HOME%\tools\bin`, and `%ANDROID_HOME%\platform-tools` to your PATH.
- **Appium**: Install globally using npm (`npm install -g appium`).
- **Appium Drivers**:
  - For Android: `appium driver install uiautomator2`
  - For iOS: `appium driver install xcuitest` (requires macOS and Xcode for iOS testing).
- **Appium Inspector**: Download from [Appium Inspector Releases](https://github.com/appium/appium-inspector/releases) for UI element inspection.
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred IDE for Java development.
- **Maven**: For dependency management and test execution.
- **ADB (Android Debug Bridge)**: For interacting with Android devices/emulators.
- **Git**: To clone and manage the repository.

Optional:
- **Android Emulator**: Configured via Android Studio’s AVD Manager.
- **Real Devices**: Connected via USB with USB debugging enabled (Android) or developer mode enabled (iOS).

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Abdullahmostafah/Amnco_Mobile_Appium.git
   cd Amnco_Mobile_Appium
   ```

2. **Install Appium**:
   ```bash
   npm install -g appium
   appium driver install uiautomator2
   appium driver install xcuitest
   ```

3. **Verify Appium Installation**:
   ```bash
   appium --version
   ```

4. **Set Up Android SDK**:
   - Install Android Studio or the standalone Android SDK.
   - Configure environment variables:
     ```bash
     export ANDROID_HOME=<path-to-sdk>
     export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools
     ```

5. **Install Project Dependencies**:
   ```bash
   mvn install
   ```

6. **Prepare the APK**:
   - Place the Amnco application APK in the `apps/` directory.
   - Update the `app` capability in the configuration file with the path to the APK (e.g., `apps/amnco.apk`).

## Project Structure

```
Amnco_Mobile_Appium/
├── apps/                    # Directory for APK/IPA files
├── src/
│   ├── main/
│   │   ├── java/            # Utility classes and page objects
│   │   └── resources/       # Configuration files (e.g., capabilities)
│   └── test/
│       ├── java/            # Test cases and test suites
│       └── resources/       # TestNG/Cucumber configuration files
├── scripts/                 # Shell scripts for setup or test execution
├── pom.xml                  # Maven dependencies and build configuration
├── README.md                # Project documentation
└── config.properties        # Framework configuration
```

## Running Tests

1. **Start Appium Server**:
   ```bash
   appium
   ```
   Alternatively, start programmatically using `AppiumServiceBuilder` in your test setup.

2. **Configure Desired Capabilities**:
   - Update `src/main/resources/capabilities.json` or equivalent with the appropriate device and app details (see [Desired Capabilities](#desired-capabilities)).

3. **Run Tests**:
   - For Android:
     ```bash
     mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng-android.xml
     ```
   - For iOS:
     ```bash
     mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng-ios.xml
     ```

4. **Using Appium Inspector**:
   - Open Appium Inspector and provide the Appium server URL (e.g., `http://127.0.0.1:4723/wd/hub`).
   - Set the desired capabilities and click "Start Session" to inspect the app’s UI.

5. **View Results**:
   - Test results and logs are stored in `target/` (e.g., Allure reports or screenshots).
   - For Allure reports (if configured):
     ```bash
     allure serve target/allure-results
     ```

## Desired Capabilities

Example capabilities for Android testing:

```json
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:deviceName": "Pixel_3a",
  "appium:udid": "<device-udid>",
  "appium:app": "<path-to-apk>/amnco.apk",
  "appium:appPackage": "com.amnco.app",
  "appium:appActivity": "com.amnco.app.MainActivity",
  "appium:noReset": true,
  "appium:avd": "Pixel_3a",
  "appium:avdLaunchTimeout": 180000
}
```

- Replace `<device-udid>` with the device ID (use `adb devices` to find it).
- Replace `<path-to-apk>` with the actual path to the Amnco APK.
- Adjust `appPackage` and `appActivity` based on the Amnco app’s configuration.

For iOS, update `platformName` to `iOS`, `automationName` to `XCUITest`, and provide the appropriate `.ipa` file and bundle ID.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

Please ensure your code follows the project’s coding standards and includes relevant tests.

## ✅ Status
✔️ Just a proof of concept for a company project

## ✍️ Author
Abdullah Mostafa

GitHub: @Abdullahmostafah
