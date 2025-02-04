INSERT INTO tb_category (name, image_url, created_at, updated_at) VALUES ('Camisetas', 'https://example.com/category_camisetas.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_category (name, image_url, created_at, updated_at) VALUES ('Moletons', 'https://example.com/category_moletons.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Rock Preto', 'Camiseta preta com estampa de rock', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Moletom Cinza', 'Moletom cinza confortável', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Bandas Branca', 'Camiseta branca com estampa de bandas', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Moletom Preto Rock', 'Moletom preto com tema de rock', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product (name, description, category_id, created_at, updated_at) VALUES ('Camiseta Anime Azul', 'Camiseta azul com estampa de anime', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('color', 'Preto', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('color', 'Vermelho', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('size', 'M', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_attribute (attribute_type, attribute_value, created_at, updated_at) VALUES ('size', 'G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (1, 3, 1, 'https://example.com/camiseta_preta.png', 59.90, 50, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (2, 4, 2, 'https://example.com/moletom_cinza.png', 120.00, 30, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (3, 3, 2, 'https://example.com/camiseta_bandas_branca.png', 65.90, 30, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (4, 4, 1, 'https://example.com/moletom_preto_rock.png', 120.00, 25, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_product_sku (product_id, size_attribute_id, color_attribute_id, image_url, price, quantity, is_default, created_at, updated_at) VALUES (5, 3, 1, 'https://example.com/camiseta_anime_azul.png', 59.90, 40, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

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
INSERT INTO tb_product_theme (product_id, theme_id, created_at) VALUES (5, 1, current_timestamp);
