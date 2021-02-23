-- 会議室
INSERT INTO meeting_room (room_name)
VALUES ('新木場');
INSERT INTO meeting_room (room_name)
VALUES ('辰巳');
INSERT INTO meeting_room (room_name)
VALUES ('豊洲');
INSERT INTO meeting_room (room_name)
VALUES ('月島');
INSERT INTO meeting_room (room_name)
VALUES ('新富町');
INSERT INTO meeting_room (room_name)
VALUES ('銀座一丁目');
INSERT INTO meeting_room (room_name)
VALUES ('有楽町');


-- 会議室の予約可能日
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 1);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 1);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 1);

INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 2);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 2);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 2);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 3);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 3);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 3);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 4);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 4);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 4);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 5);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 5);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 5);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 6);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 6);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 6);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE - 1, 7);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE, 7);
INSERT INTO reservable_room (reserved_date, room_id)
VALUES (CURRENT_DATE + 1, 7);

-- ダミーユーザー
INSERT INTO usr(user_id, first_name, last_name, password, role_name)
VALUES ('taro-yamada', '太郎', '山田', '$2a$10$7wwqHVHGq3EFoLchOofQ6OZXO9FILPSZ271RoOg6JJC9UqmqtS12G', 'USER');