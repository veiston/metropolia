# User Acceptance Test (UAT) Report & Test Cases

**Course**: Software Testing / Spring 2026  
**Assignment**: In-class Assignment (2) Week 5 — Exercise User Acceptance Test (UAT)  
**Project**: Temperature Converter with Database Localization (Sprint 6 Criteria / Sprint 7 Tasks)  
**Author / Test Engineer**: Veikka Liukkonen  

---

## 1. Objective & Scope

The objective of this User Acceptance Test (UAT) is to perform comprehensive end-to-end functional testing on critical features of the finalized Temperature Converter application. The tests verify that all customer and architectural criteria defined in Sprint 6 are met prior to final delivery, including:
- Runtime dynamic UI localization (en, fi, sv, ja, ar)
- Bidirectional Right-To-Left (RTL) layout switching for Arabic
- Database-backed localization with the Translation Table pattern
- Graceful English fallback mechanisms
- Mathematical accuracy for temperature conversions
- Threshold detection for extreme temperatures
- Input validation and exception safety
- Persistence and display of the 5 most recent conversions with language and timestamps

---

## 2. Test Cases (Table 1 Format)

### Test Case 1: Application Launch & Default English UI Initialization
| Field | Value |
| :--- | :--- |
| **Name** | 1. Application Launch & Default English UI Initialization |
| **Design Date** | 2026-11-23 |
| **Preconditions** | SQLite database file is present or automatically created; JDK 21 installed |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Run `mvn javafx:run` | Main window opens at 460x520 resolution | Pass | Clean start without errors |
| 2 | Inspect window title | Window title is "Temperature Converter" | Pass | Matches English bundle |
| 3 | Inspect default dropdown values | Language is "English", Source is "Celsius", Target is "Fahrenheit" | Pass | Default values loaded correctly |
| 4 | Inspect unit description | Displays English description for Celsius | Pass | Fetched from SQLite DB |

**Post-condition**: Application is running in English and ready for input

---

### Test Case 2: Runtime Language Switch to Finnish (`fi_FI`)
| Field | Value |
| :--- | :--- |
| **Name** | 2. Runtime Language Switch to Finnish (`fi_FI`) |
| **Design Date** | 2026-11-23 |
| **Preconditions** | Application is running in English mode |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Click language dropdown | Dropdown opens listing supported languages | Pass | Clean rendering |
| 2 | Select "Finnish" | UI reloads immediately without application restart | Pass | Scene root reloaded |
| 3 | Inspect window title & buttons | Title changes to "Lämpötilamuunnin"; button shows "Muunna ja tallenna" | Pass | UI labels from MessagesBundle_fi_FI |
| 4 | Inspect unit descriptions | Description shows "Metrinen lämpötila-asteikko..." | Pass | Localized data from DB |

**Post-condition**: UI is displayed in Finnish

---

### Test Case 3: Runtime Language Switch to Swedish (`sv_SE`)
| Field | Value |
| :--- | :--- |
| **Name** | 3. Runtime Language Switch to Swedish (`sv_SE`) |
| **Design Date** | 2026-11-23 |
| **Preconditions** | Application is running |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Select "Swedish" from language dropdown | UI reloads dynamically into Swedish | Pass | Seamless transition |
| 2 | Inspect window title | Title is "Temperaturomvandlare" | Pass | Accurate bundle text |
| 3 | Inspect UI labels and prompts | Prompts show "Välj språk:", "Från:", "Till:" | Pass | Swedish bundle verified |
| 4 | Inspect unit descriptions | Description shows "Metrisk temperaturskala..." | Pass | Correctly queried from DB |

**Post-condition**: UI is displayed in Swedish

---

### Test Case 4: Runtime Language Switch to Japanese (`ja_JP`)
| Field | Value |
| :--- | :--- |
| **Name** | 4. Runtime Language Switch to Japanese (`ja_JP`) |
| **Design Date** | 2026-11-23 |
| **Preconditions** | System supports UTF-8 display |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Select "Japanese" from language dropdown | UI reloads with Japanese locale | Pass | Reloaded instantly |
| 2 | Inspect window title & labels | Title is "温度変換器"; button is "変換して保存" | Pass | Accurate translation |
| 3 | Inspect unit names in dropdowns | Units display as "摂氏 (C)", "華氏 (F)", "ケルビン (K)" | Pass | Kanji/Katakana intact |
| 4 | Inspect unit description | Description displays "水の氷点を0度、沸点を100度とする温度目盛。" | Pass | UTF-8 DB encoding verified |

**Post-condition**: UI is displayed in Japanese

---

### Test Case 5: Language Switch to Arabic (`ar_SA`) & Right-To-Left (RTL) Layout
| Field | Value |
| :--- | :--- |
| **Name** | 5. Language Switch to Arabic (`ar_SA`) & Right-To-Left (RTL) Layout |
| **Design Date** | 2026-11-23 |
| **Preconditions** | Application running in LTR mode |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Select "Arabic" from language dropdown | UI reloads with Arabic locale | Pass | Seamless reload |
| 2 | Inspect Node Orientation | Layout direction shifts to Right-To-Left (`RIGHT_TO_LEFT`) | Pass | RTL layout verified |
| 3 | Inspect Arabic unit names | Dropdowns display "درجة مئوية", "فهرنهايت", "كلفن" | Pass | Arabic script rendered correctly |
| 4 | Inspect Arabic description | Description displays Arabic explanation | Pass | Queried from DB `unit_translation` |

**Post-condition**: UI is displayed in Arabic with right-to-left layout

---

### Test Case 6: Database Localization English Fallback
| Field | Value |
| :--- | :--- |
| **Name** | 6. Database Localization English Fallback |
| **Design Date** | 2026-11-23 |
| **Preconditions** | DAO queries a unit with a non-existent language code |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Execute DAO query with language `de` or unknown | Query executes with `LEFT JOIN` and `COALESCE` | Pass | No SQL exception |
| 2 | Check returned unit names | Returns English canonical names ("Celsius", "Fahrenheit", "Kelvin") | Pass | Fallback logic verified |
| 3 | Check returned description | Returns English default description | Pass | Fallback description intact |

**Post-condition**: English unit names and descriptions are returned for the unsupported language

---

### Test Case 7: Conversion Calculation & Formatted Result Display
| Field | Value |
| :--- | :--- |
| **Name** | 7. Conversion Calculation & Formatted Result Display |
| **Design Date** | 2026-11-23 |
| **Preconditions** | App running in English; units set to Celsius and Fahrenheit |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Enter "100.0" into temperature input | Value is accepted in text field | Pass | Clean input |
| 2 | Set source unit to "Celsius" and target to "Fahrenheit" | Dropdowns reflect selections | Pass | Selections set |
| 3 | Click "Convert & Save" button | Result label displays "100 Celsius = 212 Fahrenheit" | Pass | Accurate math (212.00) |
| 4 | Change to Kelvin and convert 0 Celsius | Result displays "0 Celsius = 273.15 Kelvin" | Pass | Exact conversion verified |

**Post-condition**: Conversion results are shown and saved to the database history

---

### Test Case 8: Extreme Temperature Threshold Detection & Warning Banner
| Field | Value |
| :--- | :--- |
| **Name** | 8. Extreme Temperature Threshold Detection & Warning Banner |
| **Design Date** | 2026-11-23 |
| **Preconditions** | Threshold boundaries defined as < -40°C or > +50°C |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Enter "55.0" Celsius and click "Convert & Save" | Conversion result calculated and warning "Warning: Extreme temperature!" displayed | Pass | High threshold triggered |
| 2 | Enter "-45.0" Celsius and click "Convert & Save" | Conversion calculated and warning message appended | Pass | Low threshold triggered |
| 3 | Enter "20.0" Celsius and click "Convert & Save" | Conversion calculated without any warning banner | Pass | Normal temp not flagged |

**Post-condition**: Warning is shown only for temperatures below -40°C or above +50°C

---

### Test Case 9: Input Validation for Empty and Non-Numeric Values
| Field | Value |
| :--- | :--- |
| **Name** | 9. Input Validation for Empty and Non-Numeric Values |
| **Design Date** | 2026-11-23 |
| **Preconditions** | Application running |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Leave input field empty and click "Convert & Save" | Result displays "Please fill all fields." without crash | Pass | Handled gracefully |
| 2 | Enter non-numeric text "hello" and click "Convert & Save" | Result displays "Invalid number. Please try again." without crash | Pass | Handled gracefully |
| 3 | Verify app stability | App remains fully responsive and ready for new input | Pass | Zero unhandled exceptions |

**Post-condition**: No record is saved and the application stays responsive

---

### Test Case 10: Database Conversion Persistence & Last 5 History Records Display
| Field | Value |
| :--- | :--- |
| **Name** | 10. Database Conversion Persistence & Last 5 History Records Display |
| **Design Date** | 2026-11-23 |
| **Preconditions** | SQLite database connection active |
| **Executed by** | Veikka Liukkonen |
| **Execution Date**| 2026-11-23 |

| Step | Action | Expected System Response | Pass / Fail | Comment |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Perform 6 distinct conversions | Each conversion triggers `TempRecordDAO.save()` | Pass | Records written to SQLite |
| 2 | Inspect `historyView` list in GUI | Exactly the 5 most recent conversions are listed | Pass | Limit 5 enforced |
| 3 | Verify record format | Each line shows input, from unit, output, to unit, `[lang]`, and timestamp | Pass | Format: `100.0 Celsius -> 212.0 Fahrenheit [en] (2026-11-23 ...)` |
| 4 | Switch language | History list reloads with unit names translated into active language | Pass | Dynamic localized history view |

**Post-condition**: The 5 most recent conversions are shown in the history list

---

## 3. Sprint 7 Reporting Summary Table

Test Engineer 2 and 3 columns are filled in once teammates report their own results.

| Test Case | Test Engineer 1 (Veikka L.) | Test Engineer 2 | Test Engineer 3 |
| :--- | :---: | :---: | :---: |
| **TC 1: App Launch & Default UI** | Pass | | |
| **TC 2: Finnish Language Switch** | Pass | | |
| **TC 3: Swedish Language Switch** | Pass | | |
| **TC 4: Japanese Language Switch** | Pass | | |
| **TC 5: Arabic Switch & RTL** | Pass | | |
| **TC 6: DB English Fallback** | Pass | | |
| **TC 7: Conversion Calculation** | Pass | | |
| **TC 8: Extreme Temp Detection** | Pass | | |
| **TC 9: Error & Empty Validation** | Pass | | |
| **TC 10: DB History (Last 5)** | Pass | | |

### Short Description of the Overall Results
All 10 User Acceptance Test cases passed in Test Engineer 1's execution. Team results for Test Engineers 2 and 3 are pending.
