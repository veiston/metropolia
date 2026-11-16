-- Database Initialization Script for In-class Assignment 6: Database Localization
-- Localization Approach: Translation Table
-- Database: SQLite / MariaDB / MySQL compatible (UTF-8)

-- 1. Base table for units (language-neutral)
CREATE TABLE IF NOT EXISTS temperature_unit (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE,
    symbol TEXT NOT NULL,
    category TEXT NOT NULL DEFAULT 'temperature'
);

-- 2. Translation table: stores localized names and descriptions per unit and language
CREATE TABLE IF NOT EXISTS unit_translation (
    unit_id INTEGER NOT NULL,
    lang TEXT NOT NULL,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (unit_id, lang),
    FOREIGN KEY (unit_id) REFERENCES temperature_unit(id) ON DELETE CASCADE
);

-- 3. Measurement table 1: Temperature conversion records
CREATE TABLE IF NOT EXISTS temp_record (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    input_value REAL NOT NULL,
    source_unit_id INTEGER NOT NULL,
    output_value REAL NOT NULL,
    target_unit_id INTEGER NOT NULL,
    language TEXT NOT NULL DEFAULT 'en',
    timestamp TEXT NOT NULL DEFAULT '',
    FOREIGN KEY (source_unit_id) REFERENCES temperature_unit(id),
    FOREIGN KEY (target_unit_id) REFERENCES temperature_unit(id)
);

-- 4. Measurement table 2: Speed / distance / time records (multi-table measurement tracking)
CREATE TABLE IF NOT EXISTS speed_measurement (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    distance REAL NOT NULL,
    distance_unit_id INTEGER NOT NULL,
    time REAL NOT NULL,
    time_unit_id INTEGER NOT NULL,
    speed REAL NOT NULL,
    speed_unit_id INTEGER NOT NULL,
    language TEXT NOT NULL DEFAULT 'en',
    timestamp TEXT NOT NULL DEFAULT '',
    FOREIGN KEY (distance_unit_id) REFERENCES temperature_unit(id),
    FOREIGN KEY (time_unit_id) REFERENCES temperature_unit(id),
    FOREIGN KEY (speed_unit_id) REFERENCES temperature_unit(id)
);

-- Populate Base Units (Temperature + Speed, Distance, Time)
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (1, 'Celsius', 'C', 'temperature');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (2, 'Fahrenheit', 'F', 'temperature');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (3, 'Kelvin', 'K', 'temperature');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (4, 'Kilometre per hour', 'km/h', 'speed');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (5, 'Mile per hour', 'mph', 'speed');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (6, 'Metre per second', 'm/s', 'speed');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (7, 'Kilometre', 'km', 'distance');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (8, 'Mile', 'mi', 'distance');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (9, 'Hour', 'h', 'time');
INSERT OR IGNORE INTO temperature_unit (id, name, symbol, category) VALUES (10, 'Second', 's', 'time');

-- Unit 1: Celsius (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(1, 'en', 'Celsius', 'Metric temperature scale where water freezes at 0 degrees and boils at 100 degrees.'),
(1, 'fi', 'Celsius', 'Metrinen lämpötila-asteikko, jossa veden jäätymispiste on 0 astetta ja kiehumispiste 100 astetta.'),
(1, 'sv', 'Celsius', 'Metrisk temperaturskala där vattnets fryspunkt är 0 grader och kokpunkt 100 grader.'),
(1, 'ja', '摂氏', '水の氷点を0度、沸点を100度とする温度目盛。'),
(1, 'ar', 'درجة مئوية', 'مقياس درجة حرارة يعتمد على نقطة تجمد الماء عند 0 درجة وغليانه عند 100 درجة.');

-- Unit 2: Fahrenheit (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(2, 'en', 'Fahrenheit', 'Temperature scale where water freezes at 32 degrees and boils at 212 degrees.'),
(2, 'fi', 'Fahrenheit', 'Lämpötila-asteikko, jossa vesi jäätyy 32 asteessa ja kiehuu 212 asteessa.'),
(2, 'sv', 'Fahrenheit', 'Temperaturskala där vatten fryser vid 32 grader och kokar vid 212 grader.'),
(2, 'ja', '華氏', '水の氷点を32度、沸点を212度とする温度目盛。'),
(2, 'ar', 'فهرنهايت', 'مقياس درجة حرارة يتجمد عنده الماء عند 32 درجة ويغلي عند 212 درجة.');

-- Unit 3: Kelvin (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(3, 'en', 'Kelvin', 'Absolute temperature scale where zero represents absolute zero.'),
(3, 'fi', 'Kelvin', 'Absoluuttinen lämpötila-asteikko, jossa nolla vastaa absoluuttista nollapistettä.'),
(3, 'sv', 'Kelvin', 'Absolut temperaturskala där noll motsvarar absoluta nollpunkten.'),
(3, 'ja', 'ケルビン', '絶対零度を0とする絶対温度目盛。'),
(3, 'ar', 'كلفن', 'مقياس درجة الحرارة المطلقة حيث يمثل الصفر الصفر المطلق.');

-- Unit 4: Kilometre per hour (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(4, 'en', 'Kilometre per hour', 'Speed unit representing kilometres travelled in one hour.'),
(4, 'fi', 'Kilometriä tunnissa', 'Nopeusyksikkö, joka ilmaisee tunnissa kuljetun matkan kilometreinä.'),
(4, 'sv', 'Kilometer i timmen', 'Hastighetsenhet som anger körda kilometer per timme.'),
(4, 'ja', '時速キロメートル', '1時間あたりに進むキロメートルを表す速度単位。'),
(4, 'ar', 'كيلومتر في الساعة', 'وحدة سرعة تمثل عدد الكيلومترات المقطوعة في ساعة واحدة.');

-- Unit 5: Mile per hour (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(5, 'en', 'Mile per hour', 'Speed unit representing statute miles travelled in one hour.'),
(5, 'fi', 'Mailia tunnissa', 'Nopeusyksikkö, joka ilmaisee tunnissa kuljetun matkan maileina.'),
(5, 'sv', 'Mil i timmen', 'Hastighetsenhet som anger engelska mil per timme.'),
(5, 'ja', '時速マイル', '1時間あたりに進むマイルを表す速度単位。'),
(5, 'ar', 'ميل في الساعة', 'وحدة سرعة تمثل عدد الأميال المقطوعة في ساعة واحدة.');

-- Unit 6: Metre per second (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(6, 'en', 'Metre per second', 'SI unit of speed representing metres travelled in one second.'),
(6, 'fi', 'Metriä sekunnissa', 'SI-nopeusyksikkö, joka ilmaisee sekunnissa kuljetun matkan metreinä.'),
(6, 'sv', 'Meter per sekund', 'SI-hastighetsenhet som anger meter per sekund.'),
(6, 'ja', '秒速メートル', '1秒間に進むメートルを表すSI速度単位。'),
(6, 'ar', 'متر في الثانية', 'وحدة السرعة في النظام الدولي وتمثل الأمتار المقطوعة في ثانية واحدة.');

-- Unit 7: Kilometre (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(7, 'en', 'Kilometre', 'Distance unit equal to 1000 metres.'),
(7, 'fi', 'Kilometri', 'Pituusyksikkö, joka vastaa 1000 metriä.'),
(7, 'sv', 'Kilometer', 'Längdenhet som motsvarar 1000 meter.'),
(7, 'ja', 'キロメートル', '1000メートルに相当する距離の単位。'),
(7, 'ar', 'كيلومتر', 'وحدة مسافة تعادل 1000 متر.');

-- Unit 8: Mile (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(8, 'en', 'Mile', 'Imperial distance unit equal to 1609.34 metres.'),
(8, 'fi', 'Maili', 'Brittiläinen pituusyksikkö, joka vastaa 1609,34 metriä.'),
(8, 'sv', 'Engelsk mil', 'Engelsk längdenhet som motsvarar 1609,34 meter.'),
(8, 'ja', 'マイル', '約1609.34メートルに相当する距離の単位。'),
(8, 'ar', 'ميل', 'وحدة مسافة إنجليزية تعادل 1609.34 متراً.');

-- Unit 9: Hour (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(9, 'en', 'Hour', 'Time unit equal to 60 minutes.'),
(9, 'fi', 'Tunti', 'Aikayksikkö, joka vastaa 60 minuuttia.'),
(9, 'sv', 'Timme', 'Tidsenhet som motsvarar 60 minuter.'),
(9, 'ja', '時間', '60分に相当する時間の単位。'),
(9, 'ar', 'ساعة', 'وحدة زمنية تعادل 60 دقيقة.');

-- Unit 10: Second (en, fi, sv, ja, ar)
INSERT OR IGNORE INTO unit_translation (unit_id, lang, name, description) VALUES
(10, 'en', 'Second', 'SI base unit of time.'),
(10, 'fi', 'Sekunti', 'Ajan SI-perusyksikkö.'),
(10, 'sv', 'Sekund', 'SI-basenhet för tid.'),
(10, 'ja', '秒', '時間のSI基本単位。'),
(10, 'ar', 'ثانية', 'الوحدة الأساسية للوقت في النظام الدولي.');
