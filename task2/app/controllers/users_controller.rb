class UsersController < ApplicationController
  before_action :set_user_by_id, only: [  :finish_signup]
  before_action :set_user_by_format, only: [:show, :edit, :update, :destroy, :block]

  before_filter :authenticate_user!
  respond_to :html, :json
  # GET /users/:id.:format
  def show
    # authorize! :read, @user
    @users = User.all
  end

  # GET /users/:id/edit
  def edit
    # authorize! :update, @user
  end

  # PATCH/PUT /users/:id.:format
  def update
    # authorize! :update, @user
    respond_to do |format|
      if @user.update(user_params)
        sign_in(@user == current_user ? @user : current_user, :bypass => true)
        format.html { redirect_to @user, notice: 'Your profile was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: 'edit' }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
    end
  end

  # GET/PATCH /users/:id/finish_signup
  def finish_signup
    # authorize! :update, @user 
    #if request.patch? && params[:user] #&& params[:user][:email]
    #  if @user.update(user_params)
       # @user.skip_reconfirmation!
       # sign_in(@user, :bypass => true)
        redirect_to @user, notice: 'Your profile was successfully updated.'
    #  else
    #    @show_errors = true
    #  end
    #end
  end

  # DELETE /users/:id.:format
  def destroy
    #authorize! :delete, @user
    @user.destroy
    redirect_to root_url
  end

  def action_with_users
    action = params[:action_with_users]

    if(action=="block")
      block_users(params[:user_id])
    elsif(action=="unblock")
      unblock_users(params[:user_id])
    elsif(action=="delete")
      delete_users(params[:user_id])
    end
    redirect_back(fallback_location: root_path)
  end
  
  private
    def set_user_by_id
      @user = User.find(params[:id])
    end

    def block_users(user_ids)
      user_ids.each do |id|
        User.find(id).lock_access!
      end
    end

    def unblock_users(user_ids)
      user_ids.each do |id|
        User.find(id).unlock_access!
      end
    end

    def delete_users(user_ids)
      user_ids.each do |id|
        User.find(id).destroy
      end
    end

    def set_user_by_format
      @user = User.find(params[:format])
    end

    def user_params
      accessible = [ :name, :email ] # extend with your own params
      accessible << [ :password, :password_confirmation ] unless params[:user][:password].blank?
      params.require(:user).permit(accessible)
    end
end