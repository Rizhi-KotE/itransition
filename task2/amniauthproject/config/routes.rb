Rails.application.routes.draw do
  
  namespace :users do
    get 'omniauth_callbacks/vkontakte'
  end

  get 'user/index'

  devise_for :users,
  controllers: {omniauth_callbacks: "users/omniauth_callbacks_controller" }
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  root 'user#index'
end
