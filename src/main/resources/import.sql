INSERT INTO tb_category (name, image_url, created_at, updated_at) VALUES ('Camisetas', 'https://i.imgur.com/FUC67h0.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_category (name, image_url, created_at, updated_at) VALUES ('Moletons', 'https://i.imgur.com/FUC67h0.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta A Day To Remember', 'Camiseta A Day To Remember descrição', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Moletom Cinza', 'Moletom cinza confortável', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Deftones', 'Camiseta Deftones descrição', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Moletom Preto Rock', 'Moletom preto com tema de rock', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Pearl Jam', 'Camiseta Pearl Jam descrição', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Moletom Outro', 'Camiseta azul com estampa de anime', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Ramones', 'Camiseta Ramones descrição', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Slipknot', 'Camiseta Slipknot descrição', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('color', 'Preto', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('color', 'Branco', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('size', 'P', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('size', 'M', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('size', 'G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('size', 'GG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (1, 3, 1, 'https://i.imgur.com/NiHToqU.png', 59.90, 50, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (1, 4, 1, 'https://i.imgur.com/NiHToqU.png', 59.90, 50, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (2, 4, 2, 'https://i.imgur.com/EjThPLE.png', 120.00, 30, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (3, 3, 2, 'https://i.imgur.com/vsN5Dfw.png', 65.90, 30, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (4, 4, 1, 'https://i.imgur.com/Iw6zWBQ.png', 120.00, 25, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (5, 3, 1, 'https://i.imgur.com/hwecbBl.png', 59.90, 40, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (6, 3, 1, 'https://i.imgur.com/fIe2mcW.png', 70.90, 40, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (7, 3, 1, 'https://i.imgur.com/fm1bg0V.png', 78.90, 40, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (8, 3, 1, 'https://i.imgur.com/aeZC1gq.png', 80.90, 40, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_user (name, email, password, cpf, created_at, updated_at) VALUES ('user test', 'user@test.com', '$2a$10$9dykYZs3J2wWSKpIGFTvpeToaqc8mjuiokx3bJlfvHny1eJxxb99W', '93756473728', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_theme (name, created_at, updated_at) VALUES ('Rock', current_timestamp, current_timestamp);
INSERT INTO tb_theme (name, created_at, updated_at) VALUES ('Anime', current_timestamp, current_timestamp);
INSERT INTO tb_theme (name, created_at, updated_at) VALUES ('Filmes', current_timestamp, current_timestamp);
INSERT INTO tb_theme (name, created_at, updated_at) VALUES ('Séries', current_timestamp, current_timestamp);
INSERT INTO tb_theme (name, created_at, updated_at) VALUES ('Desenhos', current_timestamp, current_timestamp);

INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (1, 1, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (2, 3, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (3, 2, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (4, 4, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (5, 5, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (6, 5, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (7, 3, current_timestamp);
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (8, 1, current_timestamp);
