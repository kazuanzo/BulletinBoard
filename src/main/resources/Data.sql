--ユーザー--
INSERT INTO account (id,user_name,first_name,last_name,role_name,password) values(1,'test','太郎','営業','USER','$2a$10$BfBV5caNZ.ibGZvdSvXvGe8xzc6eiwOBUuCq9I1/OjXrkWl5fnVlS');
INSERT INTO account (id,user_name,first_name,last_name,role_name,password) values(2,'ret','太郎','営業','USER','$2a$10$BfBV5caNZ.ibGZvdSvXvGe8xzc6eiwOBUuCq9I1/OjXrkWl5fnVlS');
INSERT INTO account (id,user_name,first_name,last_name,role_name,password) values(3,'re','太郎','営業','USER','$2a$10$BfBV5caNZ.ibGZvdSvXvGe8xzc6eiwOBUuCq9I1/OjXrkWl5fnVlS');
--ユーザー名＝test --パスワード＝test

--駅--
INSERT INTO station (id,station_name) values(1,'成増駅');

INSERT INTO station (id,station_name) values(2,'池袋駅');

--掲示板タイプ--
INSERT INTO board_type (id,board_type) values(1,'スポーツ');
INSERT INTO board_type (id,board_type) values(2,'アミューズメント');


--掲示板--
INSERT INTO board (id,board_type_id,board_name,board_content,create_account_id) values(1,1,'フットサルしよう！','フットサルしたい人集まりましょう！',1);
INSERT INTO board (id,board_type_id,board_name,board_content,create_account_id) values(2,1,'バスケしよう！','バスケしたい人集まりましょう！',1);
INSERT INTO board (id,board_type_id,board_name,board_content,create_account_id) values(3,2,'ディズニー行こう！','ディズニー行きたい人集まりましょう！',1);

--コメント--
INSERT INTO comment (id,account_id,board_id,comment) values(1,1,1,'面倒臭い');
INSERT INTO comment (id,account_id,board_id,comment) values(2,2,1,'興味あり');
