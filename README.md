# RabbiClient

Заглушка лаунчера Minecraft Java для телефонов. Kotlin + Jetpack Compose (Material 3).
Пакет: `com.rabbi.client`, minSdk 26, targetSdk 34, ориентация sensorLandscape, полноэкранный режим.

## Как открыть
1. Распакуйте архив.
2. Android Studio → File → Open → выберите папку `RabbiClient`.
3. Дождитесь Gradle Sync (скачается Gradle 8.9 и зависимости). Нужен JDK 17 (встроенный в Android Studio подходит).

## Зависимости
Прописаны в `app/build.gradle.kts`: core-ktx, activity-compose, Compose BOM (ui, foundation, material3), navigation-compose. Ничего лишнего.

## Как собрать APK
Build → Build Bundle(s) / APK(s) → Build APK(s).
Готовый файл: `app/build/outputs/apk/debug/app-debug.apk`.

## Структура
- `MainActivity.kt` — вход, полноэкранный режим
- `ui/RabbiClientScreen.kt` — главный экран
- `ui/components/` — TopBar, NewsPanel, SidebarButton
- `ui/RabbiClientNavHost.kt` — навигация и экраны-заглушки разделов
- `data/NicknameRepository.kt` — ник в SharedPreferences
- `res/drawable/ic_preview_placeholder.xml` — превью 16:9 (замените на своё)
