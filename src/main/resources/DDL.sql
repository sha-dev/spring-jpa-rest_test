-- Project Name : BOOK-ON
-- Date/Time    : 2016/07/29 17:49:18
-- Author       : mishima_manabu
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- 書籍状態マスタテーブル
create table BOOK_STATUS_MASTER (
  ID character varying(5) not null
  , STATUS_NAME character varying(32) not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint BOOK_STATUS_MASTER_PKC primary key (ID)
) ;

-- 書籍タグテーブル
create table BOOK_TAG (
  ID serial not null
  , BOOK_INFO_ID integer not null
  , TAG_NAME_MANAGEMENT_ID integer not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint BOOK_TAG_PKC primary key (ID)
) ;

-- タグ名管理テーブル
create table TAG_NAME_MANAGEMENT (
  ID serial not null
  , TAG_NAME character varying(32) not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint TAG_NAME_MANAGEMENT_PKC primary key (ID)
) ;

alter table TAG_NAME_MANAGEMENT add constraint TAG_NAME_MANAGEMENT_IX1
  unique (TAG_NAME) ;

-- 推奨記録テーブル
create table RECOMMENDED_RECORD (
  ID serial not null
  , BOOK_INFO_ID integer not null
  , ACCOUNT_ID character varying(32) not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint RECOMMENDED_RECORD_PKC primary key (ID)
) ;

-- 読書記録テーブル
create table READING_RECORD (
  ID serial not null
  , BOOK_INFO_ID integer not null
  , ACCOUNT_ID character varying(32) not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint READING_RECORD_PKC primary key (ID)
) ;

-- 処理種別マスタテーブル
create table PROCESS_TYPE_MASTER (
  ID character varying(5) not null
  , PROCESS_TYPE_NAME character varying(32) not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint PROCESS_TYPE_MASTER_PKC primary key (ID)
) ;

-- 書籍状態履歴テーブル
create table BOOK_STATUS_HISTORY (
  ID serial not null
  , PROCESS_TYPE_MASTER_ID character varying(5) not null
  , BOOK_ID integer
  , BOOK_INFO_ID integer not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint BOOK_STATUS_HISTORY_PKC primary key (ID)
) ;

-- 貸出情報テーブル
create table RENTAL_INFO (
  ID serial not null
  , BOOK_ID integer not null
  , ACCOUNT_ID character varying(32) not null
  , RENTAL_DATE date not null
  , RETURN_DUE_DATE date not null
  , RETURN_DATE date
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint RENTAL_INFO_PKC primary key (ID)
) ;

-- 書籍テーブル
create table BOOK (
  ID character varying(5) not null
  , BOOK_INFO_ID integer not null
  , BOOK_STATUS_MASTER_ID integer not null
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint BOOK_PKC primary key (ID)
) ;

-- 書籍情報テーブル
create table BOOK_INFO (
  ID serial not null
  , BOOK_NAME character varying(256) not null
  , AUTHOR character varying(126) not null
  , ISBN integer not null
  , PUBLISHED_DATE date
  , CREATED_AT timestamp not null
  , UPDATE_AT timestamp
  , VERSION integer not null
  , UPDATE_ACCOUNT_ID character varying(32)
  , constraint BOOK_INFO_PKC primary key (ID)
) ;

alter table BOOK_INFO add constraint BOOK_INFO_IX1
  unique (ISBN) ;

comment on table BOOK_STATUS_MASTER is '書籍状態マスタテーブル	 書籍状態マスタテーブル';
comment on column BOOK_STATUS_MASTER.ID is 'ID';
comment on column BOOK_STATUS_MASTER.STATUS_NAME is '状態名';
comment on column BOOK_STATUS_MASTER.CREATED_AT is '登録日時';
comment on column BOOK_STATUS_MASTER.UPDATE_AT is '更新日時';
comment on column BOOK_STATUS_MASTER.VERSION is 'バージョン';
comment on column BOOK_STATUS_MASTER.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table BOOK_TAG is '書籍タグテーブル	 書籍タグテーブル';
comment on column BOOK_TAG.ID is 'ID';
comment on column BOOK_TAG.BOOK_INFO_ID is '書籍情報ID';
comment on column BOOK_TAG.TAG_NAME_MANAGEMENT_ID is 'タグ名管理ID';
comment on column BOOK_TAG.CREATED_AT is '登録日時';
comment on column BOOK_TAG.UPDATE_AT is '更新日時';
comment on column BOOK_TAG.VERSION is 'バージョン';
comment on column BOOK_TAG.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table TAG_NAME_MANAGEMENT is 'タグ名管理テーブル	 タグ名管理テーブル';
comment on column TAG_NAME_MANAGEMENT.ID is 'ID';
comment on column TAG_NAME_MANAGEMENT.TAG_NAME is 'タグ名';
comment on column TAG_NAME_MANAGEMENT.CREATED_AT is '登録日時';
comment on column TAG_NAME_MANAGEMENT.UPDATE_AT is '更新日時';
comment on column TAG_NAME_MANAGEMENT.VERSION is 'バージョン';
comment on column TAG_NAME_MANAGEMENT.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table RECOMMENDED_RECORD is '推奨記録テーブル	 推奨記録テーブル';
comment on column RECOMMENDED_RECORD.ID is 'ID';
comment on column RECOMMENDED_RECORD.BOOK_INFO_ID is '書籍情報ID';
comment on column RECOMMENDED_RECORD.ACCOUNT_ID is 'アカウントID';
comment on column RECOMMENDED_RECORD.CREATED_AT is '登録日時';
comment on column RECOMMENDED_RECORD.UPDATE_AT is '更新日時';
comment on column RECOMMENDED_RECORD.VERSION is 'バージョン';
comment on column RECOMMENDED_RECORD.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table READING_RECORD is '読書記録テーブル	 読書記録テーブル';
comment on column READING_RECORD.ID is 'ID';
comment on column READING_RECORD.BOOK_INFO_ID is '書籍情報ID';
comment on column READING_RECORD.ACCOUNT_ID is 'アカウントID';
comment on column READING_RECORD.CREATED_AT is '登録日時';
comment on column READING_RECORD.UPDATE_AT is '更新日時';
comment on column READING_RECORD.VERSION is 'バージョン';
comment on column READING_RECORD.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table PROCESS_TYPE_MASTER is '処理種別マスタテーブル	 処理種別マスタテーブル';
comment on column PROCESS_TYPE_MASTER.ID is 'ID';
comment on column PROCESS_TYPE_MASTER.PROCESS_TYPE_NAME is '処理種別名';
comment on column PROCESS_TYPE_MASTER.CREATED_AT is '登録日時';
comment on column PROCESS_TYPE_MASTER.UPDATE_AT is '更新日時';
comment on column PROCESS_TYPE_MASTER.VERSION is 'バージョン';
comment on column PROCESS_TYPE_MASTER.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table BOOK_STATUS_HISTORY is '書籍状態履歴テーブル	 書籍操作履歴テーブル';
comment on column BOOK_STATUS_HISTORY.ID is 'ID';
comment on column BOOK_STATUS_HISTORY.PROCESS_TYPE_MASTER_ID is '処理種別マスタID';
comment on column BOOK_STATUS_HISTORY.BOOK_ID is '書籍ID';
comment on column BOOK_STATUS_HISTORY.BOOK_INFO_ID is '書籍情報ID';
comment on column BOOK_STATUS_HISTORY.CREATED_AT is '登録日時';
comment on column BOOK_STATUS_HISTORY.UPDATE_AT is '更新日時';
comment on column BOOK_STATUS_HISTORY.VERSION is 'バージョン';
comment on column BOOK_STATUS_HISTORY.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table RENTAL_INFO is '貸出情報テーブル	 貸出情報テーブル';
comment on column RENTAL_INFO.ID is 'ID';
comment on column RENTAL_INFO.BOOK_ID is '書籍ID';
comment on column RENTAL_INFO.ACCOUNT_ID is 'アカウントID';
comment on column RENTAL_INFO.RENTAL_DATE is 'レンタル日';
comment on column RENTAL_INFO.RETURN_DUE_DATE is '返却予定日';
comment on column RENTAL_INFO.RETURN_DATE is '返却日';
comment on column RENTAL_INFO.CREATED_AT is '登録日時';
comment on column RENTAL_INFO.UPDATE_AT is '更新日時';
comment on column RENTAL_INFO.VERSION is 'バージョン';
comment on column RENTAL_INFO.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table BOOK is '書籍テーブル	 書籍テーブル';
comment on column BOOK.ID is 'ID';
comment on column BOOK.BOOK_INFO_ID is '書籍情報ID';
comment on column BOOK.BOOK_STATUS_MASTER_ID is '書籍状態マスタID';
comment on column BOOK.CREATED_AT is '登録日時';
comment on column BOOK.UPDATE_AT is '更新日時';
comment on column BOOK.VERSION is 'バージョン';
comment on column BOOK.UPDATE_ACCOUNT_ID is '更新アカウントID';

comment on table BOOK_INFO is '書籍情報テーブル	 書籍情報テーブル';
comment on column BOOK_INFO.ID is 'ID';
comment on column BOOK_INFO.BOOK_NAME is '書籍名';
comment on column BOOK_INFO.AUTHOR is '著者';
comment on column BOOK_INFO.ISBN is 'ISBN';
comment on column BOOK_INFO.PUBLISHED_DATE is '発行年月';
comment on column BOOK_INFO.CREATED_AT is '登録日時';
comment on column BOOK_INFO.UPDATE_AT is '更新日時';
comment on column BOOK_INFO.VERSION is 'バージョン';
comment on column BOOK_INFO.UPDATE_ACCOUNT_ID is '更新アカウントID';

