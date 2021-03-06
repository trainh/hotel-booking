USE [HotelBooking]
GO
/****** Object:  Table [dbo].[tbl_Account]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Account](
	[email] [varchar](100) NOT NULL,
	[password] [varchar](256) NOT NULL,
 CONSTRAINT [PK_tbl_Account] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Account_Information]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Account_Information](
	[email] [varchar](100) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[phone] [varchar](10) NOT NULL,
	[address] [nvarchar](200) NOT NULL,
	[roleID] [int] NOT NULL,
	[createDate] [date] NOT NULL,
	[statusID] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Account_Information] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_DiscountCode]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_DiscountCode](
	[codeDis] [varchar](50) NOT NULL,
	[discount] [float] NOT NULL,
	[expiryDate] [date] NULL,
 CONSTRAINT [PK_tbl_DiscountCode] PRIMARY KEY CLUSTERED 
(
	[codeDis] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_History]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_History](
	[historyID] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[hotel] [varchar](100) NOT NULL,
	[roomID] [int] NOT NULL,
	[roomNumber] [int] NOT NULL,
	[kindOfRoom] [varchar](50) NOT NULL,
	[price] [int] NOT NULL,
	[bookingDate] [date] NOT NULL,
	[checkOutDate] [date] NOT NULL,
	[codeDis] [varchar](50) NULL,
	[total] [int] NOT NULL,
	[statusID] [int] NOT NULL,
	[statusDelete] [bit] NOT NULL,
 CONSTRAINT [PK_tbl_History] PRIMARY KEY CLUSTERED 
(
	[historyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Hotel]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Hotel](
	[hotel] [varchar](100) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_Hotel] PRIMARY KEY CLUSTERED 
(
	[hotel] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Role]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Role](
	[roleID] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_Role] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Room]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Room](
	[roomID] [int] NOT NULL,
	[roomNumber] [int] NOT NULL,
	[hotel] [varchar](100) NOT NULL,
	[email] [varchar](100) NULL,
	[kindOfRoom] [varchar](50) NOT NULL,
	[price] [int] NOT NULL,
	[dateBooking] [date] NULL,
	[dateCheck] [date] NULL,
	[statusID] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Room] PRIMARY KEY CLUSTERED 
(
	[roomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Status]    Script Date: 10/20/2021 9:10:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Status](
	[statusID] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_Status] PRIMARY KEY CLUSTERED 
(
	[statusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_Account] ([email], [password]) VALUES (N'trainhse140119@fpt.edu.vn', N'15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225')
INSERT [dbo].[tbl_Account] ([email], [password]) VALUES (N'traitrantruon@gmail.com', N'15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225')
INSERT [dbo].[tbl_Account] ([email], [password]) VALUES (N'traitrantruon2000@gmail.com', N'2f25e5feaa1332709fee2d53cc8f805a7768e81b776005e3238713e4a21516f8')
INSERT [dbo].[tbl_Account] ([email], [password]) VALUES (N'traitrantruon20000@gmail.com', N'd333a3e59bbb8878df4822a4874858fee57d484d516c9f61d90bcab3cee33cbf')
GO
INSERT [dbo].[tbl_Account_Information] ([email], [name], [phone], [address], [roleID], [createDate], [statusID]) VALUES (N'trainhse140119@fpt.edu.vn', N'AdminPage', N'0374192404', N'54 ÄÆ°á»ng 12D', 1, CAST(N'2021-10-09' AS Date), 1)
INSERT [dbo].[tbl_Account_Information] ([email], [name], [phone], [address], [roleID], [createDate], [statusID]) VALUES (N'traitrantruon@gmail.com', N'Nguyen Hoang Trai', N'0374192404', N'54, 12D, HCM', 2, CAST(N'2021-10-09' AS Date), 1)
INSERT [dbo].[tbl_Account_Information] ([email], [name], [phone], [address], [roleID], [createDate], [statusID]) VALUES (N'traitrantruon@gmail.comm', N'Nguy?n Hoàng Trai', N'0123456789', N'54 du?ng 12D', 2, CAST(N'2021-10-10' AS Date), 1)
INSERT [dbo].[tbl_Account_Information] ([email], [name], [phone], [address], [roleID], [createDate], [statusID]) VALUES (N'traitrantruon2000@gmail.com', N'Nguyen Hoang Trai', N'0374192404', N'54 ÄÆ°á»ng 12D', 2, CAST(N'2021-10-13' AS Date), 1)
INSERT [dbo].[tbl_Account_Information] ([email], [name], [phone], [address], [roleID], [createDate], [statusID]) VALUES (N'traitrantruon20000@gmail.com', N'Nguyen Hoang Trai', N'0374192404', N'54, 12D, HCM', 2, CAST(N'2021-10-19' AS Date), 1)
GO
INSERT [dbo].[tbl_DiscountCode] ([codeDis], [discount], [expiryDate]) VALUES (N'', 1, NULL)
INSERT [dbo].[tbl_DiscountCode] ([codeDis], [discount], [expiryDate]) VALUES (N'MAGIAMGIA_10%', 0.9, CAST(N'2021-10-30' AS Date))
INSERT [dbo].[tbl_DiscountCode] ([codeDis], [discount], [expiryDate]) VALUES (N'MAGIAMGIA_20%', 0.8, CAST(N'2021-10-01' AS Date))
GO
SET IDENTITY_INSERT [dbo].[tbl_History] ON 

INSERT [dbo].[tbl_History] ([historyID], [email], [hotel], [roomID], [roomNumber], [kindOfRoom], [price], [bookingDate], [checkOutDate], [codeDis], [total], [statusID], [statusDelete]) VALUES (6, N'traitrantruon@gmail.com', N'BD-Hotel', 1, 1, N'Single', 1000000, CAST(N'2021-10-19' AS Date), CAST(N'2021-10-20' AS Date), N'MAGIAMGIA_10%', 900000, 7, 0)
SET IDENTITY_INSERT [dbo].[tbl_History] OFF
GO
INSERT [dbo].[tbl_Hotel] ([hotel], [address]) VALUES (N'BD-Hotel', N'Binh Duong')
INSERT [dbo].[tbl_Hotel] ([hotel], [address]) VALUES (N'DN-Hotel', N'Dong Nai')
INSERT [dbo].[tbl_Hotel] ([hotel], [address]) VALUES (N'HCM-Hotel', N'Ho Chi Minh')
INSERT [dbo].[tbl_Hotel] ([hotel], [address]) VALUES (N'HN-Hotel', N'Ha Noi')
INSERT [dbo].[tbl_Hotel] ([hotel], [address]) VALUES (N'HP-Hotel', N'Hai Phong')
GO
INSERT [dbo].[tbl_Role] ([roleID], [name]) VALUES (1, N'ADMIN')
INSERT [dbo].[tbl_Role] ([roleID], [name]) VALUES (2, N'USER')
GO
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (1, 1, N'BD-Hotel', N'traitrantruon@gmail.com', N'Single', 1000000, CAST(N'2021-10-19' AS Date), CAST(N'2021-10-20' AS Date), 4)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (2, 2, N'BD-Hotel', NULL, N'Single', 1100000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (3, 3, N'BD-Hotel', NULL, N'Single', 1200000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (4, 4, N'BD-Hotel', NULL, N'Double', 1300000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (5, 5, N'BD-Hotel', NULL, N'Double', 1400000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (6, 6, N'BD-Hotel', NULL, N'Double', 1500000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (7, 7, N'BD-Hotel', NULL, N'Family', 1600000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (8, 8, N'BD-Hotel', NULL, N'Family', 1700000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (9, 9, N'BD-Hotel', NULL, N'Family', 1800000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (10, 1, N'DN-Hotel', NULL, N'Single', 1050000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (11, 2, N'DN-Hotel', NULL, N'Single', 1150000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (12, 3, N'DN-Hotel', NULL, N'Single', 1250000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (13, 4, N'DN-Hotel', NULL, N'Double', 1350000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (14, 5, N'DN-Hotel', NULL, N'Double', 1450000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (15, 6, N'DN-Hotel', NULL, N'Double', 1550000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (16, 7, N'DN-Hotel', NULL, N'Family', 1650000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (17, 8, N'DN-Hotel', NULL, N'Family', 1750000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (18, 9, N'DN-Hotel', NULL, N'Family', 1850000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (19, 1, N'HCM-Hotel', NULL, N'Single', 1155000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (20, 2, N'HCM-Hotel', NULL, N'Single', 1255000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (21, 3, N'HCM-Hotel', NULL, N'Single', 1355000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (22, 4, N'HCM-Hotel', NULL, N'Double', 1455000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (23, 5, N'HCM-Hotel', NULL, N'Double', 1555000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (24, 6, N'HCM-Hotel', NULL, N'Double', 1655000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (25, 7, N'HCM-Hotel', NULL, N'Family', 1755000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (26, 8, N'HCM-Hotel', NULL, N'Family', 1855000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (27, 9, N'HCM-Hotel', NULL, N'Family', 1955000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (28, 1, N'HN-Hotel', NULL, N'Single', 1195000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (29, 2, N'HN-Hotel', NULL, N'Single', 1295000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (30, 3, N'HN-Hotel', NULL, N'Single', 1395000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (31, 4, N'HN-Hotel', NULL, N'Double', 1495000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (32, 5, N'HN-Hotel', NULL, N'Double', 1595000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (33, 6, N'HN-Hotel', NULL, N'Double', 1695000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (34, 7, N'HN-Hotel', NULL, N'Family', 1795000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (35, 8, N'HN-Hotel', NULL, N'Family', 1895000, NULL, NULL, 3)
INSERT [dbo].[tbl_Room] ([roomID], [roomNumber], [hotel], [email], [kindOfRoom], [price], [dateBooking], [dateCheck], [statusID]) VALUES (36, 9, N'HN-Hotel', NULL, N'Family', 1995000, NULL, NULL, 3)
GO
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (1, N'ACTIVE')
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (2, N'INACTIVE')
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (3, N'EMPTY')
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (4, N'BOOKED')
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (5, N'BOOKING')
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (6, N'PAID')
INSERT [dbo].[tbl_Status] ([statusID], [name]) VALUES (7, N'UNPAID')
GO
ALTER TABLE [dbo].[tbl_Account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Account_tbl_Account_Information] FOREIGN KEY([email])
REFERENCES [dbo].[tbl_Account_Information] ([email])
GO
ALTER TABLE [dbo].[tbl_Account] CHECK CONSTRAINT [FK_tbl_Account_tbl_Account_Information]
GO
ALTER TABLE [dbo].[tbl_Account_Information]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Account_Information_tbl_Role] FOREIGN KEY([roleID])
REFERENCES [dbo].[tbl_Role] ([roleID])
GO
ALTER TABLE [dbo].[tbl_Account_Information] CHECK CONSTRAINT [FK_tbl_Account_Information_tbl_Role]
GO
ALTER TABLE [dbo].[tbl_Account_Information]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Account_Information_tbl_Status] FOREIGN KEY([statusID])
REFERENCES [dbo].[tbl_Status] ([statusID])
GO
ALTER TABLE [dbo].[tbl_Account_Information] CHECK CONSTRAINT [FK_tbl_Account_Information_tbl_Status]
GO
ALTER TABLE [dbo].[tbl_History]  WITH CHECK ADD  CONSTRAINT [FK_tbl_History_tbl_Account] FOREIGN KEY([email])
REFERENCES [dbo].[tbl_Account] ([email])
GO
ALTER TABLE [dbo].[tbl_History] CHECK CONSTRAINT [FK_tbl_History_tbl_Account]
GO
ALTER TABLE [dbo].[tbl_History]  WITH CHECK ADD  CONSTRAINT [FK_tbl_History_tbl_DiscountCode] FOREIGN KEY([codeDis])
REFERENCES [dbo].[tbl_DiscountCode] ([codeDis])
GO
ALTER TABLE [dbo].[tbl_History] CHECK CONSTRAINT [FK_tbl_History_tbl_DiscountCode]
GO
ALTER TABLE [dbo].[tbl_History]  WITH CHECK ADD  CONSTRAINT [FK_tbl_History_tbl_Room] FOREIGN KEY([roomID])
REFERENCES [dbo].[tbl_Room] ([roomID])
GO
ALTER TABLE [dbo].[tbl_History] CHECK CONSTRAINT [FK_tbl_History_tbl_Room]
GO
ALTER TABLE [dbo].[tbl_History]  WITH CHECK ADD  CONSTRAINT [FK_tbl_History_tbl_Status] FOREIGN KEY([statusID])
REFERENCES [dbo].[tbl_Status] ([statusID])
GO
ALTER TABLE [dbo].[tbl_History] CHECK CONSTRAINT [FK_tbl_History_tbl_Status]
GO
ALTER TABLE [dbo].[tbl_Room]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Room_tbl_Account] FOREIGN KEY([email])
REFERENCES [dbo].[tbl_Account] ([email])
GO
ALTER TABLE [dbo].[tbl_Room] CHECK CONSTRAINT [FK_tbl_Room_tbl_Account]
GO
ALTER TABLE [dbo].[tbl_Room]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Room_tbl_Hotel] FOREIGN KEY([hotel])
REFERENCES [dbo].[tbl_Hotel] ([hotel])
GO
ALTER TABLE [dbo].[tbl_Room] CHECK CONSTRAINT [FK_tbl_Room_tbl_Hotel]
GO
ALTER TABLE [dbo].[tbl_Room]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Room_tbl_Status] FOREIGN KEY([statusID])
REFERENCES [dbo].[tbl_Status] ([statusID])
GO
ALTER TABLE [dbo].[tbl_Room] CHECK CONSTRAINT [FK_tbl_Room_tbl_Status]
GO
