PGDMP     #    &                y            AppEducativa    13.2    13.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16477    AppEducativa    DATABASE     c   CREATE DATABASE "AppEducativa" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE "AppEducativa";
                postgres    false                       0    16596    advance 
   TABLE DATA           @   COPY public.advance (id, theme, percentage_advance) FROM stdin;
    public          postgres    false    207   W                 0    16612    numberlinestext 
   TABLE DATA           Z   COPY public.numberlinestext (id, lines_context, lines_example, lines_problem) FROM stdin;
    public          postgres    false    208   t       �          0    16508    problem 
   TABLE DATA           c   COPY public.problem (id, statement, problem, indentation, type_problem, lines_problem) FROM stdin;
    public          postgres    false    203   �       �          0    16492    ranking 
   TABLE DATA           9   COPY public.ranking (id, score, userprofile) FROM stdin;
    public          postgres    false    201   5       �          0    16545    theme 
   TABLE DATA           �   COPY public.theme (id, context, example, percentage_completion, problem, previous_theme, reward_coin, theme_category, indextheme, lines_context, lines_example) FROM stdin;
    public          postgres    false    205   �       �          0    16539    theme_category 
   TABLE DATA           I   COPY public.theme_category (id, levelcategory, typecategory) FROM stdin;
    public          postgres    false    204   #       �          0    16503    type_problem 
   TABLE DATA           =   COPY public.type_problem (id, type, description) FROM stdin;
    public          postgres    false    202   l       �          0    16478    userprofile 
   TABLE DATA           w   COPY public.userprofile (nickname, name, email, password, date_birth, registration_date, level, coin, gem) FROM stdin;
    public          postgres    false    200   "       �          0    16578 
   userxtheme 
   TABLE DATA           G   COPY public.userxtheme (userprofile, theme, advancextheme) FROM stdin;
    public          postgres    false    206   �              x������ � �            x������ � �      �   �  x��W�n7>�O���.���4n�Z���|qi��ܒ���S�{ȡ�-� ћ�I�͐����8�lr8��|3μJ}RҤm�&U�U�zGʇؐS�Q?�t*���G���F�CT���LUg�ǽ���l�3�E<"�(����CE�f4TKR���+�{����y�01ٚ�:u;��"��W��G��vN�h�wPK>Ԧ�α]5�p�h��hȇ4R��ʪnhf;D�z���\_|��55�Y]�Sy;>\ǀ�����[�8jOqXr�߱vma�EN�����h�NR�R$6�d�!�����G6��ӣC�J�����;m��z���m��O:�B�¶�c
�*�*�.;�o����׉a�ԙT�}��(�I�T�rCڨBHyCУ��8�{M-�줢�tI�ɕAb)=*�0W�to`t�~U�V�
�ZB\�{���+��÷��SG]h/����`z����IPn���zpXU��"YUU��j��Gu�t�@fRU?18)�Ύ������5��~��Np��]������^ϫj��a���y�H~]U�����o_[�xQU�Fa���g�#�o��O���x��p0�'�A�~�
z+��+#�M!1�!0#յ~�;;�cݯ�����IP$�3����8����г�t���rk��[WCf� ���ڸ�m3g��`uu�i�  �~�>~hC�E�]�p8�&)����5a@'s-������k�(��$������|�*ʭ�V��K�Vwa���J��2A���9ڷTs�tn���|����Լ�\��J�0mn��jpW�߈ՍME=��Ȭ���	��X��	d1��.LC�S��Q�F.�Cry���	cl=��6	�U���e�D�A#C�+�?<ML�k4�R%��.��fu?��K@�4�6H
ĬP"R����ەZ��*)�O�zu��c�L`dJS��6�G��[	0;��{�{�å�{����~H
��{�M�}�i���������;	��X�K��#PD��)S&c��Tl#����/��"��mh���vaM���\W�t����n�kC�E�Va��B_^p_��e �G�V{���'�����T�O�����>i�i�/��[O�3�y�����'��'���:����h�"�q�������V=ς�ƦLD�y��̙�ݻxY|ب�'*��wL�����1r���H��)�@W�pǓm6>-pT�y���k�3׽���[�=yD���&{��B^0_�T�#�����t� nY�eyb )p��憷��q��z�P��e���B�e��r�{��"3+Bޠ�ԙ�^�G��w!K`8o�#uސp7��qӉ���6���E��+�!���c�pFc޾7�M��.HS�a#�ɴ>���a����%���蜉����^`��yg��Ťc��W��νs�y�������g_�7֍�7+ɔA��ζ@"���$0���{fN�E'�L�`}���nh)�E�Hg���,rcy�+7�v��4��N!�^{�H���䏆����/Su|wt7��Wjr�[��/����������`��˻��W��۞�Rc>�lc�2���c	���3��@�m�����v�f��d0><8���`|p5:88���      �   `   x�%�I
�0D�u�aBWK�p�l�@@0�\?C��/�z�[\t��W_�d���џg,;+�W��ؠ�v�����t�)�8cN��)=�~#����      �   n  x��VMo�6=k�c+,⬝z��M�����Y�+sA�
%.����s�!�-���͐Ү� ��+���7o�̓�U�6D;v�٘��j0Q��h;��Q�7VSTƩ|wӧ���*r�i;}����!��|s��l�Օ�ˣ#xPfotI(Z��h3�{A��h<���	��쀋�ɍԄZ��m�����[m��H��1ݪ�����ɑ�KK����a�LG��E|N8�����15����+���[
r����4"�.ݪm�v���.��G~@�5.���2\�@;'�#��4�j���[<��v&E ��jv�^2���M��9�[��4��7Bc�\�$ը`G]���Pf��&�oL�5�b=܁|����0 L�>Хz4�$t���6����<��QM��h;�/����W�G���H��z3��G����H����O	��6��fS=�Ϊ����IuQ���TϘ7!R&3�����"��Q�ګ�h#�n�u��@�,��,�akӝ�EJ���e(� 	q���[�/|c$3pu4KF��P�bP�=�i��oQ_�U����R'�juK��>R�O��2}��p����0��f���l
揽�-i܁
&���44"���x�,�H��`���؃m��*0��Wa��f��3&wi#�E���PnH# 95�-��eF5�"�P�տw�٣A�8J��H`/;jE:XQ������nh#�Z��&�	'��:�&��˜Hh|p�ې$��ʥ����g%D��g����%�H��8�:����Fǃ=+ :h����	�)����ꠤmN���ˁ�T��ʺ�-k� ^����!��Z^�6We�����#�o�$�0_�+g3�Q	�	�;Em9O2$�:ᇨS�*������R�N�5GĽ�eD�~a��hf���o� �xˆ�/��k���~�;�>''�j�΢J-�(�R%`i@���Ks�Bj���м�V2�r��Pxg����Gb�-�wV���YX7���z�p�0��Mк�Ow s��r����a����Q��,'!w�P��m�M ��ތ��P�����F����}��i��A��jfB���T�Y�[V�,�9/M=uk5���5��:ڭ-��DċX�3�����Qch�b����0W����^�9�α�<�E<ߑ�#��7&��<e �΢�2x?�C�E4Ƴ��pX:�J̗��g����+|V�WOWUU=�=�ߍ�=[�Kѵ�2��"vO6�U�.�σ%o�����`Hn
H���K�r���\^H&���0-3�8�Xmq@ƣ����k&n�v��!��Lȕ[B.#��12�j�P2bE�=��Vp��y�*���3@~^$�C*]�s�>Fh�-��g֙#x�� �'k
�a�� ��$R�na�;7��=��x`�Δ��B2ʘa�AeL�9�"/���X`аe)w%V�_�j��QF�ѱA���V��t����~6��m�']ӄ��t�͢y�sc��/���������d5��Γ��_	�����/��~'��_Y`��+k���q���c�����>�&e�s��g�K��ti�s4����(��z�Z��t5=      �   9   x�3�4���OO,�,��/�2�4�(�O/J�ML�<�9�˘Ә�-3/�8�+F��� xM�      �   �   x���M
�@��3��	
�\@
Ņ ��F��kd:)ɸ�k�����rU���%oa(�V/�4��E�v���
��5�F��`�7�4�q�
��OEP����CB�KS��s�z�5�1�F��ޱ+S���r�9��0s�����rmnI廉��G^�sa�� .�k�      �   W  x���ˎ�0���9�bh�0�@$g�^��Q(�!��O?ZXt3�I��=�/ishT�QNS���T?,2��CZ/#�����Ë����\�y��o��C�����^���(����y��&����H��(+i�1z����!����ʱ�(����gO_��M)�f0��G���CvS@��`�+�#EBr�t�E!��v���2 !�2�F��i $W���AH��=X�詊�0�ng�m;~��z:7�V(��,��I��Be3$�[����?����fQ_M5�є(N���.��r]�5�SwR��DF�aO���Xii?��uח$�ė.�      �   B   x��I��K-�4�4�*I�-0����,c8��2����,s0+1'�(5%���.���M-��qqq  G�     