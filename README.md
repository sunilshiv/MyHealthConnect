# SuperApp Architecture

```text
superapp/
│
├── app/                                   # Host application
│
├── build-logic/                           # Convention plugins & Gradle configs
│
├── core/                                  # Reusable infrastructure layer
│   ├── core-common/                       # Constants, Result wrappers, extensions
│   ├── core-utils/                        # Utility helpers
│   ├── core-ui/                           # Shared UI components
│   ├── core-designsystem/                 # Compose design system
│   ├── core-navigation/                   # Navigation engine
│   ├── core-network/                      # Retrofit, OkHttp, interceptors
│   ├── core-database/                     # Room database
│   ├── core-datastore/                    # DataStore
│   ├── core-auth/                         # Authentication manager
│   ├── core-security/                     # Encryption & biometrics
│   ├── core-analytics/                    # Firebase analytics
│   ├── core-notification/                 # Push notifications
│   ├── core-workmanager/                  # Background jobs
│   ├── core-sync/                         # Offline sync engine
│   ├── core-files/                        # File handling
│   ├── core-webrtc/                       # Video consultation engine
│   ├── core-ble/                          # BLE abstraction
│   ├── core-location/                     # Location services
│   ├── core-pdf/                          # PDF rendering
│   ├── core-player/                       # Media/video player
│   ├── core-testing/                      # Test utilities
│   └── core-config/                       # Feature flags & configs
│
├── features/                              # Super App business features
│   │
│   ├── feature-login/
│   │   ├── presentation/
│   │   ├── domain/
│   │   └── data/
│   │
│   ├── feature-home/
│   │   ├── presentation/
│   │   ├── domain/
│   │   └── data/
│   │
│   ├── feature-settings/
│   │   ├── presentation/
│   │   ├── domain/
│   │   └── data/
│   │
│   ├── feature-appointment/
│   │   ├── presentation/
│   │   ├── domain/
│   │   └── data/
│   │
│   ├── feature-consultation/
│   │   ├── presentation/
│   │   ├── domain/
│   │   └── data/
│   │
│   ├── feature-prescription/
│   │   ├── presentation/
│   │   ├── domain/
│   │   └── data/
│   │
│   ├── feature-profile/
│   └── feature-notification/
│
├── miniapps/                              # Plug & Play Mini Apps
│   │
│   ├── mini-pharmacy/
│   │   ├── pharmacy-entry/
│   │   ├── pharmacy-navigation/
│   │   ├── pharmacy-presentation/
│   │   ├── pharmacy-domain/
│   │   ├── pharmacy-data/
│   │   ├── pharmacy-cart/
│   │   ├── pharmacy-orders/
│   │   ├── pharmacy-tracking/
│   │   └── pharmacy-prescription/
│   │
│   ├── mini-lab/
│   │   ├── lab-entry/
│   │   ├── lab-navigation/
│   │   ├── lab-presentation/
│   │   ├── lab-domain/
│   │   ├── lab-data/
│   │   ├── lab-booking/
│   │   ├── lab-report/
│   │   ├── lab-home-collection/
│   │   └── lab-report-viewer/
│   │
│   ├── mini-live-tv/
│   ├── mini-wallet/
│   ├── mini-ble-health/
│   ├── mini-orders/
│   └── mini-profile/
│
├── domain/                                # Shared business contracts
│   ├── auth-domain/
│   ├── appointment-domain/
│   ├── consultation-domain/
│   ├── prescription-domain/
│   ├── payment-domain/
│   ├── pharmacy-domain/
│   ├── lab-domain/
│   ├── streaming-domain/
│   └── ble-health-domain/
│
├── data/                                  # Shared repository implementations
│   ├── auth-data/
│   ├── appointment-data/
│   ├── consultation-data/
│   ├── prescription-data/
│   ├── payment-data/
│   ├── pharmacy-data/
│   ├── lab-data/
│   ├── streaming-data/
│   └── ble-health-data/
│
├── sdk/                                   # Reusable business SDKs
│   ├── sdk-video-consultation/
│   ├── sdk-chat/
│   ├── sdk-payment/
│   ├── sdk-health-device/
│   ├── sdk-pharmacy/
│   ├── sdk-lab/
│   ├── sdk-report-viewer/
│   └── sdk-notification/
│
├── platform/                              # External service integrations
│   ├── firebase/
│   ├── websocket/
│   ├── monitoring/
│   ├── analytics/
│   ├── crashlytics/
│   └── remote-config/
│
├── dynamic-feature/                       # Play Feature Delivery
│   ├── pharmacy-dynamic/
│   └── lab-dynamic/
│
├── benchmark/                             # Macrobenchmark & Baseline Profiles
│
└── docs/                                  # Architecture documentation
```
