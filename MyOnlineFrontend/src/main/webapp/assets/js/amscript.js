$(function()
{
	var $table= $('#producttable')
	
	var jsonUrl='';
	
		if(window.categoryId=='')
		{
			jsonUrl= window.contextroot + '/json/show/all/active/products'
		}
		else
		{
			jsonUrl= window.contextroot + '/json/show/all/active/category/'
					+ window.categoryId + '/products';
		}
	
	$table.DataTable({
		
		lengthMenu:[[3,5,10,-1], ['3 Products', '5 Products', '10 Products', 'All Products'] ],
		pageLength:5, 
		ajax: {
					url : jsonUrl,
					dataSrc : '',
			   },

		columns: [
				{
					data: 'code',
					mRender: function(data, type, row)
					{
						return '<img src="' + window.contextroot +
								'/rs/images/' + data 
								+ '.jpg" class="dataTableImg"/>';
					}
													
				},
				 
				{
					data: 'code',
					bSortable: false,
				} ,
				{
					data: 'name'
				} ,
				{
					data: 'brand'
				} ,
				{
					data: 'quantity',
					mRender: function(data,type,row)
					{
						if(data < 1)
						{
							return '<span style="color:red">OUT OF STOCK!!</span>';
						}
						
						return data
					}
				} ,
				{
					data: 'unit_price',
					mRender: function(data, type, row)
					{
						return ' &#8377; ' + data
					}
					
				} ,
				
				{
					data:'id',
					
					mRender: function(data, type, row)
					{
						return '<a class= "btn btn-primary" href="'+ window.contextroot + 
						'/product/show/single/' + data + 
						'/product">VIEW</a>'
					}
				},
				
				{
					data:'id',
					
					mRender: function(data, type, row)
					{
						return '<a class= "btn btn-warning"href="">ADD TO CART</a>'
					}
				},
			], 
			
			
			});
			
			//Admin Product table code
			
			var $table= $('#adminProductsTable');
			
			var jsonUrl = window.contextroot + '/json/show/all/products';
			
			$table.DataTable({
				
				lengthMenu:[[3,5,10,-1], ['3 Products', '5 Products', '10 Products', 'All Products'] ],
				pageLength: 5, 
				ajax: {
							url: jsonUrl,
							dataSrc: '',
			   		   },
				
				columns: [
					
					{
						data: 'id',
					},
					
					{
						data: 'name',
					},
					
					{
						data: 'brand',
					},
					
					{
						data: 'quantity',
					},
					
					{
						data: 'unit_price',
						mRender: function(data, type, row)
						{
							return ' &#8377; ' + data
						}
					
					 } ,
					
					{
						data: 'active',
							   bSortable: false,
							   mRender: function(data,type,row){
								var str= '';
								if(data)
								{
									str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked">  <div class="slider round"> </div></label>';
								}
								else
								{
									str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '">  <div class="slider round"> </div></label>';
								}
								return str;
							},
					},
					{
						data:'id',
						mRender : function(data , type,row){
							return '<a class="btn btn-warning" href="'
							+contextroot
							+'/manage/edit/'
							+data
							+'/product" >EDIT</a>';
						}
					}
						
				],
				
				initComplete : function() {
						var api = this.api();

						api
								.$('.switch input[type = "checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var msg = (checked) ? 'You want to activate the product?'
													: 'You want to deactivate the product?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation/Deactivation',
														message : msg,
														callback : function(
																confirmed) {
															if (confirmed) {
																var activeurl = window.contextroot
																		+ '/manage/product/'
																		+ checkbox
																				.prop('value')
																		+ '/activation';
																$.post(
																				activeurl,
																				function(data) {
																					bootbox.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data,

																							});
																				})

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														},
													});
										});
					}
				
				});
				
});
				